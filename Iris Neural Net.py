import torch
import torch.nn as nn
import torch.nn.functional as F
import pandas as pd
import matplotlib.pyplot as plt
import time

usingcuda = False

class Model(nn.Module):
    def __init__(self, in_features=4, h1=100, h2=100, out_features=3):
        super().__init__()
        self.fc1 = nn.Linear(in_features, h1)
        self.fc2 = nn.Linear(h1, h2)
        self.out = nn.Linear(h2, out_features)
    
    def forward(self, x):
        x = F.relu(self.fc1(x))
        x = F.relu(self.fc2(x))
        x = self.out(x)
        return x
    
if usingcuda:
    model = Model().cuda()
else:
    model = Model()
    
#torch.manual_seed(32)

df = pd.read_csv('D:/School/Y2S1/CS3244 Machine Learning/PYTORCH_NOTEBOOKS/Data/iris.csv')

X = df.drop('target', axis=1)
y = df['target']
X = X.values
y = y.values
 
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.5)

if usingcuda:
    X_train = torch.Tensor(X_train).cuda()
    X_test = torch.Tensor(X_test).cuda()
    y_train = torch.LongTensor(y_train).cuda()
    y_test = torch.LongTensor(y_test).cuda()
    crit = nn.CrossEntropyLoss().cuda()

else:
    X_train = torch.Tensor(X_train)
    X_test = torch.Tensor(X_test)
    y_train = torch.LongTensor(y_train)
    y_test = torch.LongTensor(y_test)
    crit = nn.CrossEntropyLoss()
    
print(y_test.device)

opti = torch.optim.Adam(model.parameters(), lr=0.001)
ep = 1000
startn = 0
losses = []
lossesoos = []

start = time.time()

for epoch in range(ep):
    cost = crit(model.forward(X_train), y_train)
    outofsample = crit(model.forward(X_test), y_test)
    if epoch%50 == 0:
        losses.append(cost)
        lossesoos.append(outofsample)
    opti.zero_grad()
    cost.backward()
    opti.step()
    #print(epoch)

plt.plot(range(len(losses))[startn:], losses[startn:], label='training data')
plt.plot(range(len(losses))[startn:], lossesoos[startn:], 'r', label='test data')
plt.xlabel('Training Generations')
plt.ylabel('Error Function')
plt.legend()

print("--- %.3fs seconds ---" % (time.time() - start))
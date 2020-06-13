import pandas as pd
orders = pd.read_csv('D:/order_brush_order.csv')
orders.drop('orderid', inplace=True, axis=1)
orders['hour'] = pd.to_datetime(orders['event_time'])
import datetime
orders = orders.sort_values(by=['shopid','hour'])
hourref = datetime.timedelta(hours=1)

currshop = 0
currshopstart = 0
currshopend = 0
currd = {}
shops = {}
#222750
for row in range(222750):
    if currshop != orders.iloc[row,0]:
        currshop = orders.iloc[row,0]
        currshopstart = row
        currshopend = row
        currd = {orders.iloc[row,1] : 1}
        shops[orders.iloc[row,0]] = 0

        continue
        
    currshopend += 1
    
    cont = False
    while orders.iloc[currshopend,3] - orders.iloc[currshopstart,3] > hourref and currshopstart < currshopend:
        if currd[orders.iloc[currshopstart,1]] == 1:
            del currd[orders.iloc[currshopstart,1]]
        else:
            currd[orders.iloc[currshopstart,1]] -= 1
        currshopstart += 1
        if currshopstart == currshopend:
            currd = {orders.iloc[currshopstart,1] : 1}
            cont = True
            break
    
    if cont: continue
    if orders.iloc[row,1] not in currd:
        currd[orders.iloc[row,1]] = 1
    else:
        currd[orders.iloc[row,1]] += 1
        
    
    if currshopend - currshopstart + 1 >= 3 * len(currd):
        #print(orders.iloc[row,0])
        #print(currd)
        shops[orders.iloc[row,0]] = max(currd, key = currd.get)
    else:
        shops[orders.iloc[row,0]] = 0
        
for i in shops.items():
    print(i[0], i[1])
#print(shops)
result = [[k, v] for k,v in shops.items()]
answer = pd.DataFrame(result, columns =['shopid', 'userid']) 
#answer.to_csv('RetailRow.csv')

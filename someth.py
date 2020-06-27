class Word:
    def __init__(self, name):
        self.next = None
        self.name = name
    
    def setnext(self, Next):
        self.next = Next
    
    def checknext(self, query):
        return self.next == query
        
class Wordlist(object):
    def __init__(self, name):
        self.name = name
        self.words = []
    
    def addword(self, word):
        self.words.append(word)

wordlist_dict = {}


testcases = int(input())
for _ in range(testcases):
    [n_input, n_test] = input().split()
    for _ in range(int(n_input)):
        string_in = input().split()
        i = len(string_in)-1
        while i >= 0:
            if string_in[i] not in wordlist_dict:
                wordlist_dict[string_in[i]] = Wordlist(string_in[i])
            currword = Word(string_in[i])
            wordlist_dict[string_in[i]].addword(currword)
            if i != len(string_in)-1:
                currword.setnext(saveword)
            saveword = currword

            i -= 1
    for _ in range(int(n_test)):
        string_in = input().split()
        try: temp = wordlist_dict.get(string_in[0])
        
        for testword in string_in:
            
                

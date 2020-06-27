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
for i in range(testcases):
    [n_input, n_test] = input().split()
    for i in range(int(n_input)):
        string_in = input().split()
        
        for i in range len(string_in):
            if string_in[i] not in wordlist_dict:
                wordlist_dict[string_in[i]] = Wordlist(string_in[i])
            currword = Word(string_in[i])
            wordlist_dict[string_in[0]].addword(Word(None))
            if i < len(string_in-1):
                currword.setnext()
                

from random import randint
import copy
import pygame

win = pygame.display.set_mode((750,750))
pygame.display.set_caption("Omok")
BLACK = (0,0,0)
WHITE = (255,255,255)
RAND = 1
PAYOFF1 = [5,40,80,200]
PAYOFF2 = [5,10,120,200]

def makenewboard():
    board=[[0,]*15,]
    for i in range(14):
        board+=[[0,]*15,]
    return board

def clearboard():
    board=makenewboard()

board=makenewboard()

def showboard(board):
    for i in board:
        print(i)

def drawline(win, a, b):
    pygame.draw.line(win, BLACK, (a[1]*50+25, a[0]*50+25), (b[1]*50+25, b[0]*50+25), 4)
    pygame.display.update()

def checkstate(board):
    for i in range(1,3):

        #horiz
        for x in range(15):
            for y in range(11):
                if board[x][y]==board[x][y+1]\
                and board[x][y]==board[x][y+2]\
                and board[x][y]==board[x][y+3]\
                and board[x][y]==board[x][y+4]\
                and board[x][y]==i:
                    print(i," won.")
                    drawline(win, (x,y), (x,y+4))
                    return i

        #vert
        for x in range(11):
            for y in range(15):
                if board[x][y]==board[x+4][y]\
                and board[x][y]==board[x+1][y]\
                and board[x][y]==board[x+2][y]\
                and board[x][y]==board[x+3][y]\
                and board[x][y]==i:
                    print(i," won.")
                    drawline(win, (x,y), (x+4,y))
                    return i

        #diag right down        
        for x in range(11):
            for y in range(11):
                if board[x][y]==board[x+1][y+1]\
                and board[x][y]==board[x+2][y+2]\
                and board[x][y]==board[x+3][y+3]\
                and board[x][y]==board[x+4][y+4]\
                and board[x][y]==i:
                    print(i," won.")
                    drawline(win, (x,y), (x+4,y+4))
                    return i

        #diag left down
        for x in range(11):
            for y in range(4,15):
                if board[x][y]==board[x+1][y-1]\
                and board[x][y]==board[x+2][y-2]\
                and board[x][y]==board[x+3][y-3]\
                and board[x][y]==board[x+4][y-4]\
                and board[x][y]==i:
                    
                    print(i," won.")
                    drawline(win, (x,y), (x+4,y-4))
                    return i

    return 0


def reverse(board):
    for i in range(15):
        for j in range(15):
            if board[i][j]==1:
                board[i][j]=2
            elif board[i][j]==2:
                board[i][j]=1

######################################################################
'''
AND WITHIN THESE LINES I SHALL SHOWCASE MY AI PROGRAMMING CHOPS BASICALLY
SEE YOU IN GOOGLE DEEPMIND IN 4 YEARS' TIME
'''
######################################################################

def AI(board,n,PAYOFF):
    highest=-999
    if n==1:
        m=2
    else: m=1
    for a in range(15):
        for b in range(15):
            if not filled(a,b,board):
                score=evaluation(move(a,b,board,m),m,PAYOFF,a,b)+randint(-RAND,RAND)+evaluation(move(a,b,board,n),n,PAYOFF,a,b)
                if score>=highest:
                    highest=score
                    movea,moveb=a,b
                    #print("Highest for {} is now at {},{} with score {}.".format(n,a,b,highest))

    return move(movea,moveb,board,n)

def evaluation(board,a,PAYOFF,i,j):
    if a==1:
        b=2
    else: b=1
    def evahelper(board,n,i,j):
        savei = i
        savej = j
        score=0
        while j>0 and board[i][j-1]==n:
            j -= 1
        if j<=10:
            if board[i][j]==board[i][j+1] and board[i][j]==n:
                score+=PAYOFF[0]
                if board[i][j+2]==n:
                    score+=PAYOFF[1]
                    if board[i][j+3]==n:
                        score+=PAYOFF[2]
                        if board[i][j+4]==n:
                            score+=PAYOFF[3]

        i,j = savei,savej
        while i>0 and board[i-1][j]==n:
            i -= 1
        if i<=10:
            if board[i][j]==board[i+1][j] and board[i][j]==n:
                score+=PAYOFF[0]
                if board[i+2][j]==n:
                    score+=PAYOFF[1]
                    if board[i+3][j]==n:
                        score+=PAYOFF[2]
                        if board[i+4][j]==n:
                            score+=PAYOFF[3]

        i,j = savei,savej
        while i>0 and j>0 and board[i-1][j-1]==n:
            i -= 1
            j -= 1
        if i<=10 and j<=10:
            if board[i][j]==board[i+1][j+1] and board[i][j]==n:
                score+=PAYOFF[0]
                if board[i+2][j+2]==n:
                    score+=PAYOFF[1]
                    if board[i+3][j+3]==n:
                        score+=PAYOFF[2]
                        if board[i+4][j+4]==n:
                            score+=PAYOFF[3]
                            
        i,j = savei,savej
        while i>0 and j<14 and board[i-1][j+1]==n:
            i -= 1
            j += 1
        if i<=10 and j>=4:
            if board[i][j]==board[i+1][j-1] and board[i+1][j-1]==n:
                score+=PAYOFF[0]
                if board[i+2][j-2]==n:
                    score+=PAYOFF[1]
                    if board[i+3][j-3]==n:
                        score+=PAYOFF[2]
                        if board[i+4][j-4]==n:
                            score+=PAYOFF[3]
        return score
    return 0.5*evahelper(board,a,i,j)-0.5*evahelper(board,b,i,j)


######################################################################
'''
AND WITHIN THESE LINES I SHALL SHOWCASE MY AI PROGRAMMING CHOPS BASICALLY
SEE YOU IN GOOGLE DEEPMIND IN 4 YEARS' TIME
'''
######################################################################
                    
k=makenewboard()


def filled(x,y,board):
    return not board[x][y]==0

                
def move(x,y,board,n):
    if not filled(x,y,board):
        newboard=copy.deepcopy(board)
        newboard[x][y]=n
        return newboard
    else:
        print("Error: Already Filled")
        return board

def printboard(board):
    #pygame.time.delay(1000)
    win.fill((10,70,20))
    for y in range(0,15):
        for x in range(0,15):
            if board[y][x] == 1:
                pygame.draw.circle(win, WHITE, (x*50+25, y*50+25), 20)
            elif board[y][x] == 2:
                pygame.draw.circle(win, BLACK, (x*50+25, y*50+25), 20)
    pygame.display.update()


def newgame():
    myboard=makenewboard()
    myboard=move(7,7,board,2)
    run = True
    placed = 0
    while run:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False

        
        if playing:
            moveinput=input("Make a move \n")
            if moveinput=="flip":
                reverse(board)
            if moveinput=="quit":
                break
            for i in range(len(moveinput)-1):
                if moveinput[i]==',':
                    left=moveinput[:i]
                    right=moveinput[i+1:]
                    myboard=move(int(left)-1,int(right)-1,myboard,1)
        
    

        else:
            myboard=AI(myboard,1,PAYOFF1)
        printboard(myboard)
        placed += 1
        state = checkstate(myboard)
        if state != 0:
            pygame.time.delay(300)
            return state
        if placed == 224:
            print("draw.")
            return 0

        myboard=AI(myboard,2,PAYOFF1)
        placed += 1
        printboard(myboard)
        if state != 0:
            pygame.time.delay(300)
            return state
        if placed == 224:
            print("draw.")

            return 0

### Change to true if you want to play as 1 ###
playing=False
##### If not AI will play as both 1 and 2 #####

totalscore = [0,0]
while totalscore[0] < 50 and totalscore[1] < 50:
    result = newgame()
    if result != 0:
        totalscore[result-1] += 1
    else:
        totalscore[0] += 0.5
        totalscore[1] += 0.5
    print(totalscore)

    
pygame.time.delay(5000)
pygame.quit()


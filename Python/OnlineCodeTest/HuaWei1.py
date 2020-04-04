
res = []
while True:
    try:
        s = input()
        res.append(s)
    except:
        break

DaXie = ["AND","OR","NOT"]

dic1 = {"OR":1,"AND":2,"NOT":3}

dp = [[4,1,2,3],[0,4,4,3],[0,4,4,3],[0,4,4,4]]

def calWordState(word):
    if word.islower():
        return 0
    if word in DaXie:
        return dic1[word]
    else:
        return 4
def calOne(str1):
    str2 = str1.split(" ")
    N = len(str2)
    preState = 0
    curState = 0
    if N == 0:
        return 0
    elif N == 1:
        if str2[0].islower() and str2[0].isalpha():
            return  1
        else:
            return 0
    else:
        preState = calWordState(str2[0])
        if preState == 4:
            return 0
        for  i in range(1,N):
            # print(str2[i],preState)
            curState = calWordState(str2[i])
            if curState == 4:return 0
            preState = dp[preState][curState]
            if preState == 4:
                return 0

    if preState !=0: return 0
    return 1
result = []
for i in res:
    result.append(str(calOne(i)))

tee = '\n'.join(result)
print(tee)













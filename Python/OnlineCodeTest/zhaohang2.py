
'''
2
4
2 5 1 2
3 1 7 4
3
2 1 2
2 1 2
'''
def inputRow():
    s1  = int(input())
    res = []
    for i in range(s1):
        N = int(input())
        s2 = [ int(i) for i in input().split(" ")]
        s3 = [int(i) for i in input().split(" ")]
        res.append(findOne(N,s2,s3))
    return res
def cal(s1,s2):
    t1 = list(zip(s1,s2))
    return  t1
def findOne(N,s1,s2):
    t1 = cal(s1,s2)
    t1 = sorted(t1)
    t2 = sorted(t1,key=lambda x:x[1])
    # print(t1)
    # print(t2)
    count1 = 1
    count2 = 1
    for i in range(1,N):
        if t1[i][1] >= t1[i-1][1]:
            continue
        else:
            count1 += 1
    for i in range(1,N):
        if t2[i][0] >= t2[i-1][0]:
            continue
        else:
            count2 += 1
    return min(count1,count2)

t1 = inputRow()
for i in t1:
    print(i)

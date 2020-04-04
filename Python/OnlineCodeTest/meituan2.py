#一个dp加贪心问题
#最长上升子串
list1 = [1,2,4,9,5,3]


dp = [ 1 for i in range(len(list1))]
N = len(list1)
zuhe = []
start = 1
len = 0
list1 = [-1]+list1
for i in range(1,N+1):
    if list1[i] > list1[i-1]:
        len += 1
    else:
        zuhe.append((start,len))
        start = i
        len = 0

print(zuhe)

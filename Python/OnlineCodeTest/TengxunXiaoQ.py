input1 = [int(i) for i in input().split(" ")]
n = input1[0]
m = input1[1]

left ,right = 0,m-1

def calculate(first):
    count = 0
    for i in range(n):
        count += first
        first = first/2
        if first - int(first)!= 0:
            first = int(first)+1

        if first == 0:
            first = 1
        if count > m:
            return -1
    if count == m:
        return 0
    if count < m:
        return 1
res = 0
while left < right:
    temp = (left + right)//2+1
    if calculate(temp) == 0:
        left = temp
        break
    if calculate(temp) < 0:
        right = temp-1
    if calculate(temp)>0:
        left = temp

res =left

print(res)
n = int(input())
res = {}
for i in range(n):
    temp = input()
    if temp in res:
        res[temp] += 1
    else:
        res[temp] = 1

list1 = sorted(res)
result = []
for i in list1:
    result.append(i+" "+str(res[i]))
tee = '\n'.join(result)
print(tee)
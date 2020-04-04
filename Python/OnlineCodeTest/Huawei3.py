
dic1 = {}
while True:
    try:
        s = input()
        temp = s.split(":")
        dic1[temp[0]] = temp[1].split(" ")
    except:
        break
res = 1
result = []
def dfs(pre,cur):
    if cur in pre:
        global  res
        res = 0
        result.append(pre)
    else:
        for i in dic1[cur]:
            pre = pre+[cur]
            dfs(pre,i)
            # pre.pop()
dfs([],dic1['search head file'][0])
result2 = []
for i in result:
    result2.append("Bad coding -- loop include as bellow:\r\n"+' '.join(i))

if res == 1:
    print("none loop include *")
else:
    result3 = '\r\n'.join(result2)
    print(result3)

# a.h:b.h
# b.h:c.h
# c.h:a.h
# search head file:a.h

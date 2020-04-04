s1 = input()
s2 = input()
count = 0
'''
移到后面所有的
'''
def find2(s1,s2):
    pass
def find(s1,s2):
    if s1 == s2:
        return
    if len(s2) == 0:
        return
    target = s2[0]
    dic1 = {}
    index1 = s1.index(target)
    for i in range(index1):
        dic1[s1[i]] = s2.index(s1[i])
        global count
        count += 1
    temp = ''
    for i in sorted(dic1.items(),key=lambda x:x[1]):
        temp += i[0]
    s1 = s1[index1:]+temp
    find(s1[1:],s2[1:])

if set(s1) != set(s2) or len(s1) != len(s2):
    print(-1)
else:
    find(s1,s2)
    print(count)
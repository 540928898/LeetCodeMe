s1 = "aabc"
s2 = "abca"

def findCount(s1,s2):
    count = 0
    up= 0
    N = len(s2)
    for i in range(N):
        temp = s2[i]
        if up == N:
            return count
        if temp == s1[up]:
            up += 1
        else:
            while(up < N):
                up += 1
                count+= 1
                if s1[up] == temp:
                    up += 1
                    break
    return count




print(findCount(s1,s2))

def func1(input1,input2,input3):
    input3 = sorted(input3)
    if input1 %input2 != 0:
        return -1
    res1= [[]for i in range(int((input1/input2)))]
    def isValid(num):
        canAdd = []
        for i in range(int(input1/input2)):
            if num not in res1[i] and len(res1[i]) < input2:
                canAdd.append(i)
        return canAdd
    print(input3)
    for i in input3[::-1]:
        canAddBox = isValid(i)
        # if not canAddBox: return -1
        target = -float("inf")
        cur = 0
        for k in canAddBox:
            if len(res1[k]) == 0:
                if target < i:
                    cur = k
                    target = i
            else:
                if target < max(res1[k]) - i:
                    cur = k
                    target = max(res1[k]) - i

        res1[cur].append(i)
    result = 0
    for i in res1:
        result += max(i)-min(i)
    print(res1)
    return result



print(func1(12,4,[5,10,4,8,3,6,5,10,4,8,3,6]))
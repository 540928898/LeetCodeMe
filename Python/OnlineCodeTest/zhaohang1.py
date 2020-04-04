def inputRow():
    s1  = int(input())
    res = []
    for i in range(s1):
        s2 = int(input())
        s3 = [int(i) for i in input().split(" ")]
        res.append(findOne(s3,s2))
    return res


def findOne(nums,n):
    if(len(nums) == 0) :return -1
    res = 0
    for i in range(n):
        if nums[i] >= 1:
            nums[i] -= 1
            res += 1
    temp = res
    for i in range(n):
        if nums[i] >= 1:
            res += 1
            break
    if temp == res :return  -1
    else : return  res


t1 = inputRow()
for i in t1:
    print(sorted())
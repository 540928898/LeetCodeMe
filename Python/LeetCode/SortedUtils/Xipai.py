import  random

def xipai(list1):
    N = len(list1)
    for i in range(len(list1)):
        index1 = random.randint(0,N-i-1)
        list1[N-i-1],list1[index1] = list1[index1],list1[N-i-1]
    return list1

list1 = [i for i in range(10)]
print(xipai(list1))



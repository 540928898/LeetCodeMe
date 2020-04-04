from functools import cmp_to_key
import random
class node1:
    val  = 0
    def __init__(self,val):
        self.val = val
list1 = []
for i in range(10):
    list1.append(node1(random.randint(0,10)))

def cmp_class(node1,node2):
    if node1.val < node2.val:
        return -1
    if node1.val > node2.val:
        return  1
    return 0


for i in list1:
    print(i.val)


list1 = sorted(list1,key = cmp_to_key(cmp_class))
print("排序后")

for i in list1:
    print(i.val)
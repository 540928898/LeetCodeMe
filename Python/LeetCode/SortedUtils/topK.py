#TOPK问题 第一种是快速选择
#快速选择
import random
def partition(nums,left,right):
    target = nums[left]
    raw = left
    left=left+1
    while left<= right:
        while left<=right and nums[right] > target:
            right -= 1
        while left<= right and nums[left] < target:
            left += 1
        if left <= right:#这个需要注意。
            nums[left],nums[right] = nums[right],nums[left]
    nums[raw],nums[left-1] = nums[left-1],nums[raw]
    return left -1

def randomPartition(nums,left,right):
    target = random.randint(left,right)
    #随机取一个数然后交换他们的位置！！不然会出bug
    nums[target],nums[right] = nums[right],nums[target]
    pivo = partition(nums,left,right)
    return  pivo

def selectMinNum(nums,left,right,k):
    pivo = randomPartition(nums,left,right)
    if k == pivo - left + 1:
        return ;
    if k < pivo - left+1:
        selectMinNum(nums,left,pivo-1,k)
    if k > pivo - left+ 1:
        selectMinNum(nums,pivo+1,right,k-pivo+left-1)

def selectMaxNum(nums,left,right,k):
    pivo = randomPartition(nums,left,right)
    if k ==right-pivo+1:
        return;
    if k < right-pivo+1:
        selectMinNum(nums,pivo+1,right,k)
    if k > right-pivo+1:
        selectMinNum(nums,left,pivo-1,k-right+pivo-1)


#第二种是堆排序

#这个函数是从上到下进行堆的调整
def maxHeapOne(list2,index1):
    if index1*2+1 <= len(list2)-1:
        leftChild = index1*2+1
        rightChild = index1*2+2
        if rightChild > len(list2)-1:
            if list2[index1] < list2[leftChild]:
                list2[index1],list2[leftChild] = list2[leftChild],list2[index1]
            return
        if list2[index1] > list2[rightChild] and list2[index1] > list2[leftChild]:
            return
        if list2[leftChild]> list2[rightChild]:
            if list2[index1] < list2[leftChild]:
                list2[index1],list2[leftChild] = list2[leftChild],list2[index1]
                maxHeapOne(list2,leftChild)
        if list2[leftChild] < list2[rightChild]:
            if list2[index1] < list2[rightChild]:
                list2[index1],list2[rightChild] = list2[rightChild],list2[index1]
                maxHeapOne(list2,rightChild)

#这个函数是从下到上对堆进行调整，前提是其前n-1项为最大堆
def heapUpdate(list2):
    N = len(list2)
    cur = N-1
    faNode = cur>>1
    while faNode >=0:
        if list2[faNode] > list2[cur]:
            return
        if list2[faNode] < list2[cur]:
            list2[faNode],list2[cur] = list2[cur],list2[faNode]
        cur = faNode
        faNode = (faNode-1)>>1


#构建堆
def createHeap(list2):
    N = len(list2)
    # cur = N-1
    start = (N-1)>>1
    while start >= 0:#对最后一个子节点的父节点开始遍历。对每一个节点都构建最大堆。
        # print(start)
        maxHeapOne(list2,start)
        start -= 1
#获取最大值
def getMax(list2):
    createHeap(list2)
    list2[0],list2[-1] = list2[-1],list2[0]
    res = list2.pop()
    maxHeapOne(list2,0)   #取出最大值后对堆进行调整，从上到下进行调整
    return res

#求最小值用最大堆，求最大值用最小堆
def getminTop(list2,k):
    list3 = list2[:k]
    createHeap(list3)
    for i in list2[k:]:
        list3 +=[i]
        heapUpdate(list3)
        list3 = list3[-k:]
    return list3

if __name__ == '__main__':
    nums = [1,10,3,4,5,6,7,8]
    # createHeap(nums)
    list3 = getminTop(nums,3)
    print(list3)
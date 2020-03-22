'''
[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
'''
class Solution:
    def minIncrementForUnique(self, A):
        A = sorted(A)
        res = 0
        N = len(A)
        if N <= 1:
            return 0
        for i in range(1,N):
            if A[i] >A[i-1]:
                continue
            else:
                while A[i] <=A[i-1]:
                    A[i] += 1
                    res += 1
            print (A)
        return res
'''
第二种是使用地址压缩法
非常骚气
'''

if __name__ == '__main__':
    t1 = Solution()
    print (t1.minIncrementForUnique([3,2,1,2,1,7]))
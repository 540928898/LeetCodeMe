class Solution:
    def longestIncreasingPath(self, matrix):
        rowNum = len(matrix)
        colNum = len(matrix[0])
        hasMove = [[0]*len(matrix[0]) for i in range(len(matrix))]
        direction = [[0,1],[0,-1],[1,0],[-1,0]]
        def isValid(currow,curcol,nextrow,nextcol):
            if nextrow <0 or nextcol < 0 or nextrow >= rowNum or nextcol >= colNum:
                return False
            if  matrix[nextrow][nextcol] <= matrix[currow][curcol]:
                return False
            return True
        def dfs(currow,curcol):
            res = 1
            if (hasMove[currow][curcol] != 0) :return hasMove[currow][curcol];
            for i in direction:
                nextrow = currow+i[0]
                nextcol = curcol+i[1]
                if isValid(currow, curcol, nextrow, nextcol):
                    res =max(res,1+dfs(nextrow,nextcol))
            hasMove[currow][curcol] = res
            return res
        max1 = 1
        for i in range(rowNum):
            for j in range(colNum):
                max1 = max(dfs(i,j),max1)
        return max1
if __name__ == '__main__':
    matrix = [
        [9,9,4],
        [6,6,8],
        [2,1,1]
    ]
    t1= Solution()
    res = t1.longestIncreasingPath(matrix)
    print(res)
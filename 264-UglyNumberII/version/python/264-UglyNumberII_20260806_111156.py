# Last updated: 8/6/2026, 11:11:56 AM
1class NumMatrix:
2
3    def __init__(self, matrix: List[List[int]]):
4        self.dp=[[0] * (len(matrix[0])+1) for _ in range(len(matrix)+1)]
5        
6		# calculate prefix sum
7        for r in range(len(self.dp)-1):
8            for c in range(len(self.dp[0])-1):
9                self.dp[r+1][c+1]=matrix[r][c] + self.dp[r][c+1] + self.dp[r+1][c] - self.dp[r][c]
10        
11    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
12        return self.dp[row2+1][col2+1] - self.dp[row1][col2+1] - self.dp[row2+1][col1] + self.dp[row1][col1]
13                
# Last updated: 8/6/2026, 11:33:50 AM
1class Solution:
2    def countBits(self, n: int) -> List[int]:
3        dp = [0] * (n + 1)
4        sub = 1
5
6        for i in range(1, n + 1):
7            if sub * 2 == i:
8                sub = i
9            
10            dp[i] = dp[i - sub] + 1
11        
12        return dp
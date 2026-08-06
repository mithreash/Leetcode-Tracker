# Last updated: 8/6/2026, 11:15:23 AM
1class Solution:
2    def maxCoins(self, nums: List[int]) -> int:
3        n = len(nums)
4        nums.append(1)
5        nums.insert(0, 1)
6        @cache              # range in which we want to choose the last balloon to burst.
7        def dp(start, end): # we know anything outside the range lasts "longer", as we determined it will burst later
8            maxi = -(2 ** 31)
9            if end < start:
10                return 0
11
12            for i in range(start, end + 1):
13                maxi = max(maxi, dp(start, i - 1) + dp(i + 1, end) + nums[start - 1] * nums[i] * nums[end + 1])
14            
15            return maxi
16        
17        return dp(1, n)
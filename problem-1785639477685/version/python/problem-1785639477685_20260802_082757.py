# Last updated: 8/2/2026, 8:27:57 AM
1class Solution:
2    def maxPairStrength(self, nums: list[int]) -> int:
3        max_strength = 0
4        n = len(nums)
5
6        for i in range(n):
7            for j in range(i+1,n):
8                g = math.gcd (nums[i], nums[j])
9                strength = (nums[i] * nums[j]) // (g*g)
10                if strength > max_strength:
11                    max_strength = strength
12        return max_strength
13                
14        
# Last updated: 8/6/2026, 11:32:12 AM
1class Solution:
2    def increasingTriplet(self, nums):
3        min1 = float('inf')
4        min2 = float('inf')
5        for n in nums:
6            if n <= min1:
7                min1 = n  # Update first minimum
8            elif n <= min2:
9                min2 = n  # Update second minimum
10            else:
11                return True  # Found a third number greater than both
12        return False  # No triplet found
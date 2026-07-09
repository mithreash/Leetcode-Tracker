# Last updated: 7/9/2026, 3:08:35 PM
class Solution:
    def subsets(self, nums):
        result = [[]]

        for num in nums:
            result += [curr + [num] for curr in result]

        return result
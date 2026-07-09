# Last updated: 7/9/2026, 3:07:37 PM
from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums):
        nums = list(map(str, nums))

        def compare(a, b):
            if a + b > b + a:
                return -1
            elif a + b < b + a:
                return 1
            return 0

        nums.sort(key=cmp_to_key(compare))

        result = ''.join(nums)

        return '0' if result[0] == '0' else result
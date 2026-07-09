# Last updated: 7/9/2026, 3:08:48 PM
class Solution:
    def mySqrt(self, x):
        left, right = 0, x
        ans = 0

        while left <= right:
            mid = (left + right) // 2

            if mid * mid <= x:
                ans = mid
                left = mid + 1
            else:
                right = mid - 1

        return ans
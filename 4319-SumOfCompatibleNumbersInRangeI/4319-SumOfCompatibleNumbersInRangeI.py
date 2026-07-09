# Last updated: 7/9/2026, 3:06:59 PM
class Solution:
    def sumOfGoodIntegers(self, n, k):
        ans = 0
        
        start = max(1, n - k)
        end = n + k
        
        for x in range(start, end + 1):
            if (n & x) == 0:
                ans += x
                
        return ans
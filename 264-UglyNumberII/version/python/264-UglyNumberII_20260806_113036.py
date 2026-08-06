# Last updated: 8/6/2026, 11:30:36 AM
1# Python
2class Solution:
3    def isPowerOfThree(self, n: int) -> bool:
4        if n <= 0:
5            return False
6        while n % 3 == 0:
7            n //= 3
8        return n == 1
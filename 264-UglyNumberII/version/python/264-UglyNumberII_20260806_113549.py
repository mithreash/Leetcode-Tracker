# Last updated: 8/6/2026, 11:35:49 AM
1class Solution:
2    def integerBreak(self, n: int) -> int:
3        if n == 2:
4            return 1
5        if n == 3:
6            return 2
7
8        # Try to divide n into as many threes as possible
9        threes = n // 3
10        remainder = n % 3
11
12        if remainder == 1:
13            threes -= 1 # remove 3 * 1
14            remainder = 4 # create 2 * 2
15        elif remainder == 0:
16            remainder = 1 # when remainder is 0, set 1 which doesn't affect your answer.
17
18        return (3 ** threes) * remainder
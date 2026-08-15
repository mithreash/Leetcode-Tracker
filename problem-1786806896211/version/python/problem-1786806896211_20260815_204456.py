# Last updated: 8/15/2026, 8:44:56 PM
1class Solution:
2    def minOperations(self, s: str) -> int:
3        n = len(s)
4        min_total_ops = float('inf')
5        for r in range(n):
6            rotated = s[r:] + s[:r]
7            increment_cost = 0 
8            for i in range(n // 2):
9                x = ord(rotated[i]) - ord('a')
10                y = ord(rotated[n - 1 - i]) - ord('a')
11                cost_x_to_y = (y - x) % 26
12                cost_y_to_x = (x - y) % 26
13
14                increment_cost += min(cost_x_to_y, cost_y_to_x)
15            total_ops = r + increment_cost
16            if total_ops < min_total_ops:
17                min_total_ops = total_ops
18        return min_total_ops
19
20        
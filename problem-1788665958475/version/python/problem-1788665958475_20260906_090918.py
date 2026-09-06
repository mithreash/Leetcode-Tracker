# Last updated: 9/6/2026, 9:09:18 AM
1class Solution:
2    def countGoodRotations(self, nums: list[int]) -> int:
3        n =len(nums)
4        half = n // 2
5        extended = nums + nums
6        sum_first = sum(extended[0:half])
7        sum_second = sum(extended[half:n])
8        good_count = 0
9        if sum_first > sum_second:
10            good_count += 1
11        for i in range(1,n):
12            sum_first =sum_first - extended[i - 1] + extended[i + half - 1]
13            sum_second = sum_second - extended[i + half - 1] + extended[i + n -1]
14            if sum_first > sum_second:
15                good_count += 1
16        return good_count
17        
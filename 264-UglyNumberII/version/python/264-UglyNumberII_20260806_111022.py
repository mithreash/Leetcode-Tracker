# Last updated: 8/6/2026, 11:10:22 AM
1class Solution:
2    def lengthOfLIS(self, nums: List[int]) -> int:
3        res = []
4
5        def binary_search(res, n):
6            left = 0
7            right = len(res) - 1
8
9            while left <= right:
10                mid = (left + right) // 2
11                if res[mid] == n:
12                    return mid
13                elif res[mid] > n:
14                    right = mid - 1
15                else:
16                    left = mid + 1
17            
18            return left
19
20        for n in nums:
21            if not res or res[-1] < n:
22                res.append(n)
23            else:
24                idx = binary_search(res, n)
25                res[idx] = n
26        
27        return len(res)
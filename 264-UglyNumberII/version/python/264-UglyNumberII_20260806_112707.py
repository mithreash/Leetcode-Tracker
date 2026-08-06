# Last updated: 8/6/2026, 11:27:07 AM
1class Solution:
2    def wiggleSort(self, nums: List[int]) -> None:
3        """
4        Do not return anything, modify nums in-place instead.
5        """
6        arr = sorted(nums)
7
8        n = len(nums)
9        mid = (n + 1) // 2
10
11        left = arr[:mid][::-1]
12        right = arr[mid:][::-1]
13
14        i = j = 0
15
16        for k in range(n):
17            if k % 2 == 0:
18                nums[k] = left[i]
19                i += 1
20            else:
21                nums[k] = right[j]
22                j += 1
23
24    def wiggleSort1(self, nums: List[int]) -> None:
25        """
26        Do not return anything, modify nums in-place instead.
27        """
28        for i in range(1, len(nums) - 1, 2):
29            nums[i], nums[i + 1] = nums[i + 1], nums[i]
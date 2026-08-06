# Last updated: 8/6/2026, 11:37:22 AM
1class Solution:
2    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
3        intersection = []
4        for val in nums1:
5            if val in nums2:
6                intersection.append(val)
7        unique = list(set(intersection))
8        return unique
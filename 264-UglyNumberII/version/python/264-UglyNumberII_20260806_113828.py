# Last updated: 8/6/2026, 11:38:28 AM
1# Runtime: 23 ms, faster than 89.65% of Python online submissions for Intersection of Two Arrays II.
2# Memory Usage: 11.4 MB, less than 87.45% of Python online submissions for Intersection of Two Arrays II.
3class Solution(object):
4    def intersect(self, nums1, nums2):
5        # Sort both the arrays first...
6        sortedArr1 = sorted(nums1)
7        sortedArr2 = sorted(nums2)
8        # Use two pointers i and j for the two arrays and initialize both with zero.
9        i = 0
10        j = 0
11        # Create a output list to store the output...
12        output = []
13        while i < len(sortedArr1) and j < len(sortedArr2):
14            # If sortedArr1[i] is less than sortedArr2[j]...
15            # Leave the smaller element and go to next(greater) element in nums1...
16            if sortedArr1[i] < sortedArr2[j]:
17                i += 1
18            # If sortedArr1[i] is greater than sortedArr2[j]...
19            # Go to next(greater) element in nums2 array...
20            elif sortedArr2[j] < sortedArr1[i]:
21                j += 1
22            # If both the elements intersected...
23            # Add this element to output & increment both i and j.
24            else:
25                output.append(sortedArr1[i])
26                i += 1
27                j += 1
28        return output       # Return the output array...
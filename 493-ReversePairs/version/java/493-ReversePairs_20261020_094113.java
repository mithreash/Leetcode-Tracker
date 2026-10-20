// Last updated: 10/20/2026, 9:41:13 AM
1class Solution {
2
3    // Merge two sorted halves
4    private void merge(int[] nums, int low, int mid, int high) {
5
6        int[] temp = new int[high - low + 1];
7
8        int left = low;        // left half starts
9        int right = mid + 1;   // right half starts
10        int k = 0;
11
12        // Put elements in sorted order
13        while (left <= mid && right <= high) {
14
15            if (nums[left] <= nums[right]) {
16                temp[k++] = nums[left++];
17            } else {
18                temp[k++] = nums[right++];
19            }
20        }
21
22        // Copy remaining left elements
23        while (left <= mid) {
24            temp[k++] = nums[left++];
25        }
26
27        // Copy remaining right elements
28        while (right <= high) {
29            temp[k++] = nums[right++];
30        }
31
32        // Copy temp back into nums
33        for (int i = low; i <= high; i++) {
34            nums[i] = temp[i - low];
35        }
36    }
37
38    // Count reverse pairs between two sorted halves
39    private int countPairs(int[] nums, int low, int mid, int high) {
40
41        int right = mid + 1;
42        int count = 0;
43
44        // Check every element of left half
45        for (int i = low; i <= mid; i++) {
46
47            // Find all right elements satisfying:
48            // nums[i] > 2 * nums[right]
49            while (right <= high &&
50                   (long) nums[i] > 2L * nums[right]) {
51                right++;
52            }
53
54            // All elements before right are valid pairs
55            count += right - (mid + 1);
56        }
57
58        return count;
59    }
60
61    // Merge Sort + count reverse pairs
62    private int mergeSort(int[] nums, int low, int high) {
63
64        if (low >= high) {
65            return 0;
66        }
67
68        int mid = low + (high - low) / 2;
69
70        // Count pairs in left half
71        int count = mergeSort(nums, low, mid);
72
73        // Count pairs in right half
74        count += mergeSort(nums, mid + 1, high);
75
76        // Count pairs across both halves
77        count += countPairs(nums, low, mid, high);
78
79        // Merge both halves
80        merge(nums, low, mid, high);
81
82        return count;
83    }
84
85    public int reversePairs(int[] nums) {
86        return mergeSort(nums, 0, nums.length - 1);
87    }
88}
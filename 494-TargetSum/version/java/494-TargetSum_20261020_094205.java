// Last updated: 10/20/2026, 9:42:05 AM
1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        //Solution 1
4        int sum = 0;
5        for(int x : nums)
6            sum += x;
7        if(((sum - target) % 2 == 1) || (target > sum))
8            return 0;
9        
10        int n = nums.length;
11        int s2 = (sum - target)/2;
12        int[][] t = new int[n + 1][s2 + 1];
13        t[0][0] = 1;
14        
15        for(int i = 1; i < n + 1; i++) {
16            for(int j = 0; j < s2 + 1; j++) {
17                if(nums[i - 1] <= j)
18                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
19                else
20                    t[i][j] = t[i - 1][j];
21            }
22        }
23        return t[n][s2];
24        
25           //Solution 2
26//         int sum = 0;
27//         for(int x : nums)
28//             sum += x;
29//         if(((sum - target) % 2 != 0) || (target > sum))
30//             return 0;
31        
32//         int n = nums.length;
33//         int s2 = (sum - target)/2;
34        
35//         int[][] t = new int[n + 1][s2 + 1];
36//         for(int i = 0; i < n + 1; i++) {
37//             for(int j = 0; j < s2 + 1; j++) {
38//                 if(i == 0)
39//                     t[i][j] = 0;
40//                 if(j == 0)
41//                     t[i][j] = 1;
42//             }
43//         }
44        
45//         for(int i = 1; i < n + 1; i++) {
46//             for(int j = 1; j < s2 + 1; j++) {
47//                 if((nums[i - 1] > j) || (nums[i - 1] == 0))
48//                     t[i][j] = t[i - 1][j];
49//                 else
50//                     t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
51//             }
52//         }
53        
54//         int count = 0;
55//         for(int x : nums)
56//             if(x == 0)
57//                 count++;
58        
59//         return (int)(Math.pow(2,count)) * t[n][s2];
60    }
61}
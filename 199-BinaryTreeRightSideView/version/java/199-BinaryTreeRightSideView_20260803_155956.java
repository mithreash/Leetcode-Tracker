// Last updated: 8/3/2026, 3:59:56 PM
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4
5        if (n == 1) {
6            return nums[0];
7        }
8
9        int[] dp = new int[n];
10
11        dp[0] = nums[0];
12        dp[1] = Math.max(nums[0], nums[1]);
13
14        for (int i = 2; i < n; i++) {
15            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
16        }
17
18        return dp[n - 1];        
19    }
20}
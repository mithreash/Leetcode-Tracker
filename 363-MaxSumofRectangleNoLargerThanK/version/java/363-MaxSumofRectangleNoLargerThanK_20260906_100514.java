// Last updated: 9/6/2026, 10:05:14 AM
1class Solution {
2    public int maxSumSubmatrix(int[][] arr, int k) {
3        int rows = arr.length;
4        int cols = arr[0].length;
5        int maxK = Integer.MIN_VALUE;
6        for(int i = 0; i < cols; i++){
7            int dp[] = new int[rows];
8            for(int j = i; j < cols; j++){
9                for(int l = 0; l < rows; l++){
10                    dp[l] += arr[l][j];
11                }
12                int currSum = maxSubArray(dp, k);
13                maxK = Math.max(maxK, currSum);                 
14                if(maxK == k)
15                    return k;
16            }
17        }
18        return maxK;
19    }
20    public int maxSubArray(int[] arr, int k) {
21        int max = Integer.MIN_VALUE;
22        int currSum = 0;
23        TreeSet<Integer> set = new TreeSet<>();
24        set.add(0);
25        for (int i = 0; i < arr.length; i++) {
26            currSum += arr[i];
27            Integer ceilValue = set.ceiling(currSum - k);
28            if(ceilValue != null) {
29                max = Math.max(max, currSum - ceilValue);
30            }
31            set.add(currSum);
32        }
33        return max;
34    }
35}
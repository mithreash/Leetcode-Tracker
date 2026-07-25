// Last updated: 7/25/2026, 1:43:34 PM
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int[] candies = new int[n];
5        Arrays.fill(candies, 1);
6
7        for (int i = 1; i < n; i++) {
8            if (ratings[i] > ratings[i - 1]) {
9                candies[i] = candies[i - 1] + 1;
10            }
11        }
12
13        for (int i = n - 2; i >= 0; i--) {
14            if (ratings[i] > ratings[i + 1]) {
15                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
16            }
17        }
18
19        int totalCandies = 0;
20        for (int candy : candies) {
21            totalCandies += candy;
22        }
23
24        return totalCandies;
25    }
26}
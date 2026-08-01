// Last updated: 8/1/2026, 9:06:19 AM
1class Solution {
2    public int hIndex(int[] citations) {
3        Arrays.sort(citations);
4
5        int n = citations.length;
6        int h = 0;
7
8        for (int i = 0; i < n; i++) {
9            h = Math.max(h, Math.min(citations[i], n - i));
10        }
11
12        return h;
13    }
14}
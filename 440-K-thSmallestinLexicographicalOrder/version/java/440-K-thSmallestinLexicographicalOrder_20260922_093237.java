// Last updated: 9/22/2026, 9:32:37 AM
1class Solution {
2    public int arrangeCoins(int n) {
3        int x = n;
4        int i = 1;
5        do {
6            x = x - i;
7            i++;
8        } while (x >= 0);
9        return i - 2;
10    }
11}
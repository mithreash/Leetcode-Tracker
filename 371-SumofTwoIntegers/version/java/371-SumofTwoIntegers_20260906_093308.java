// Last updated: 9/6/2026, 9:33:08 AM
1class Solution {
2    public int getSum(int a, int b) {
3        while (b != 0) {
4            int c = (a & b) << 1;
5            a = a ^ b;
6            b = c;
7        }
8        return a;
9    }
10}
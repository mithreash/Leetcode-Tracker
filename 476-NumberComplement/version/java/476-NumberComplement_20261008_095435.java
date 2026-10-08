// Last updated: 10/8/2026, 9:54:35 AM
1class Solution {
2    public int findComplement(int num) {
3        if (num == 0) return 1;
4
5        int bitLength = Integer.toBinaryString(num).length();
6        
7        int mask = (1 << bitLength) - 1;
8        
9        return num ^ mask;
10    }
11}
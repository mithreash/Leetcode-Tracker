// Last updated: 9/16/2026, 2:21:33 PM
1class Solution {
2    public int findNthDigit(int n) {
3        long len=1,c=9,s=1;
4        while(n>len*c){
5        n-=len*c;
6        len++;
7        c*=10;
8        s*=10;
9
10    }
11    s+=(n-1)/len;
12    return String.valueOf(s).charAt((n-1)%(int)len)- '0';
13}
14}
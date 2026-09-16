// Last updated: 9/16/2026, 2:07:47 PM
1class Solution {
2
3    int helper(long n){
4        if(n==1) return 0;
5
6        if(n%2==0) return 1+helper(n/2);
7        else if(n==3 || n%4==1) return 1+helper(n-1);
8        else return 1+helper(n+1);
9    }
10
11    public int integerReplacement(int n) {
12        return helper((long) n);
13    }
14}
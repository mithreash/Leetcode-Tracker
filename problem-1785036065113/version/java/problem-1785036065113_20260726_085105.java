// Last updated: 7/26/2026, 8:51:05 AM
1class Solution {
2    public int largestInteger(int n, int s) {
3         if(s > 9 * n) {
4             return -1;
5         }  
6         int result = 0;
7         for(int i=0; i < n; i++){
8             int digit = Math.min(9,s);
9             result = result * 10 + digit ;
10             s -= digit;
11         }
12        return result;
13    }
14}
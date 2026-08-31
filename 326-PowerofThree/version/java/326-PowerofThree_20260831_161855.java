// Last updated: 8/31/2026, 4:18:55 PM
1class Solution {
2    public boolean isPowerOfThree(int n) {
3        if (n == 1) return true;
4        while(0 < n){
5            if (n % 3 != 0){
6                return false;
7            }
8            n = n/3;
9            if (n == 1){
10                return true;
11            }
12        }
13        return false;
14        //Consider giving an upvote
15    }
16}
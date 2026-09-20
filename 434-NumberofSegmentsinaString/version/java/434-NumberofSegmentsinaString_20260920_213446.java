// Last updated: 9/20/2026, 9:34:46 PM
1class Solution {
2    public int countSegments(String s) {
3    int t=0;
4    int c=0;
5    int n=s.length();
6    for(int i=0;i<n;i++){
7        if(s.charAt(i)!=' '&&t==0){
8            c++;
9            t=1;
10        }
11        if(s.charAt(i)==' ') t=0;
12    
13    }
14    return c;
15    }
16}
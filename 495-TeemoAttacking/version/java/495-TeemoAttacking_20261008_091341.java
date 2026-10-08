// Last updated: 10/8/2026, 9:13:41 AM
1class Solution {
2    public int findPoisonedDuration(int[] timeSeries, int duration) {
3        int n = timeSeries.length;
4        if(n==0){
5            return 0;
6        }
7        int ans = 0;
8        for(int i=0; i<n-1;i++){
9            ans = ans + Math.min(duration,timeSeries[i+1]-timeSeries[i]);
10        }
11        ans += duration ;
12        return ans ;
13    }
14}
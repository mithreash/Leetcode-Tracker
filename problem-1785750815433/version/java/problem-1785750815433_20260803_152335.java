// Last updated: 8/3/2026, 3:23:35 PM
1class Solution {
2    public int countRatioSubarrays(int[] arr, int a, int b) {
3        int n = arr.length;
4        int count = 0;
5
6        for(int i=0;i<n;i++){
7            int even = 0, odd = 0;
8            for(int j=i;j<n;j++){
9                if(arr[j]%2 == 0) even++;
10                else odd++;
11                if(odd > 0 && (long)even * b <= (long)odd * a) count++;
12            }
13        }
14        return count;
15    }
16}
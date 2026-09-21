// Last updated: 9/20/2026, 9:46:26 PM
1import java.util.Arrays;
2import java.util.Comparator;
3
4class Solution {
5    public int eraseOverlapIntervals(int[][] intervals) {
6        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
7        int prev = 0;
8        int count = 0;
9        
10        for (int i = 1; i < intervals.length; i++) {
11            if (intervals[prev][1] > intervals[i][0]) {
12                count++;
13            } else {
14                prev = i;
15            }
16        }
17        
18        return count;
19    }
20}
# Last updated: 7/26/2026, 9:20:41 AM
1class Solution:
2    def aggregateTimeSeries(self, series1: list[list[int]], series2: list[list[int]]) -> list[list[int]]:
3        timestamps = sorted(list({p[0] for p in series1} | {p[0] for p in series2}), reverse=True)
4        results = []
5        p1,p2 = len(series1) - 1, len(series2) - 1
6        next_val1, next_val2 = 0, 0
7        result = []
8        for t in timestamps:
9            if p1>=0 and series1[p1][0] == t:
10                next_val1 = series1[p1][1]
11                p1 -= 1
12            if p2>=0 and series2[p2][0] == t:
13                next_val2 = series2[p2][1]
14                p2 -= 1
15            result.append([t, next_val1 + next_val2])
16        return result[::-1]
17            
18            
19        
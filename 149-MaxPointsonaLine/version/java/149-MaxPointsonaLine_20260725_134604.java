// Last updated: 7/25/2026, 1:46:04 PM
1class Solution {
2    public int maxPoints(int[][] points) 
3    {
4        int max = 0;
5        for(int[] point_1 : points)
6        {
7            Map<Double,Integer> map= new HashMap<>();
8            for(int[] point_2 : points)
9            {
10                if(point_1 == point_2) continue;
11                
12                double slope=0;
13                // if x2 - x1 are equal then line is vertical
14                if(point_2[0] == point_1[0])
15                   slope=Double.POSITIVE_INFINITY; 
16                else
17                {
18                    // slope (m) = (y2 - y1) / (x2 - x1) 
19                    slope = (point_2[1] - point_1[1]) / (double)(point_2[0] - point_1[0]);
20                }
21                map.put( slope , map.getOrDefault(slope,0)+1 );
22                if(map.get(slope)>max)
23                    max=map.get(slope);
24            }
25        }
26        return max+1;
27    }
28}
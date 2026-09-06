// Last updated: 9/6/2026, 10:06:51 AM
1class Solution {
2    public boolean isRectangleCover(int[][] rectangles) {
3        TreeSet<int[]> set = new TreeSet<int[]>((a, b) -> {
4            if (a[3] <= b[1]) return -1;
5            else if (a[1] >= b[3]) return 1;
6            else if (a[2] <= b[0]) return -1;
7            else if (a[0] >= b[2]) return 1;
8            else return 0;
9        });
10        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
11        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
12        int totalArea = 0;
13        for (int[] i : rectangles) {
14            if (i[0] < minX) {
15                minX = i[0];
16            } if (i[1] < minY) {
17                minY = i[1];
18            } if (i[2] > maxA) {
19                maxA = i[2];
20            } if (i[3] > maxB) {
21                maxB = i[3];
22            }
23            totalArea += (i[2] - i[0]) * (i[3] - i[1]);
24            if (!set.add(i)) return false;
25        }
26        return totalArea == (maxA - minX) * (maxB - minY);
27    }
28}
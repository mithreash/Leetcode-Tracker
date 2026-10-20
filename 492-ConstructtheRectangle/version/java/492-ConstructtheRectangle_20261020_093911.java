// Last updated: 10/20/2026, 9:39:11 AM
1class Solution {
2    public int[] constructRectangle(int area) {
3
4        int width = (int) Math.sqrt(area);
5
6        while (area % width != 0) {
7            width--;
8        }
9
10        return new int[] { area / width, width };
11    }
12}
// Last updated: 7/19/2026, 8:47:44 AM
1class Solution {
2    public boolean canReach(int[] start, int[] target) {
3        int startSum = start[0] + start[1];
4        int targetSum = target[0] + target[1];
5        return (startSum % 2) ==(targetSum % 2);
6        
7    }
8}
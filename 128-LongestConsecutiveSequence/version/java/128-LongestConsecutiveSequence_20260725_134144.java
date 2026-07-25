// Last updated: 7/25/2026, 1:41:44 PM
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        if(nums.length<=1) return nums.length;
4        HashSet<Integer>set=new HashSet<>();
5        for(int i:nums) set.add(i);
6        int res=1;
7        for(int i:set){
8            int temp=1;
9            if(!set.contains(i-1)){
10                int j=i;
11                while(set.contains(j+1)){
12                    j+=1;
13                    temp++;
14                }
15            }
16            res=Math.max(res,temp);
17        }
18        return res;
19    }
20}
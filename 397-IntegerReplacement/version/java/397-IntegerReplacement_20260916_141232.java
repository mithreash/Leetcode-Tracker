// Last updated: 9/16/2026, 2:12:32 PM
1class Solution {
2    private Map<Integer, List<Integer>> map;
3    private Random ran;
4
5    public Solution(int[] nums) {
6        map = new HashMap<>();
7        ran = new Random();
8    
9        for (int i = 0; i < nums.length; i++) {
10            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
11        }
12    }
13    
14    public int pick(int target) {
15        List<Integer> indices = map.get(target);
16        
17        return indices.get(ran.nextInt(indices.size()));
18    }
19}
20
21/**
22 * Your Solution object will be instantiated and called as such:
23 * Solution obj = new Solution(nums);
24 * int param_1 = obj.pick(target);
25 */
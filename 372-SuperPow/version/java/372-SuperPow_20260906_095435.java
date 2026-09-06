// Last updated: 9/6/2026, 9:54:35 AM
1class Solution {
2    public int combinationSum4(int[] nums, int target) {
3        Integer[] memo = new Integer[target + 1];
4        return recurse(nums, target, memo);
5    }
6    
7    public int recurse(int[] nums, int remain, Integer[] memo){
8        
9        if(remain < 0) return 0;
10        if(memo[remain] != null) return memo[remain];
11        if(remain == 0) return 1;
12        
13        int ans = 0;
14        for(int i = 0; i < nums.length; i++){
15            ans += recurse(nums, remain - nums[i], memo);
16        }
17        
18        memo[remain] = ans;
19        return memo[remain];
20    }
21}
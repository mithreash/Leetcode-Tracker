// Last updated: 9/6/2026, 10:09:18 AM
1class Solution {
2    public boolean canCross(int[] stones) {
3        Map<Integer, Set<Integer>> dp = new HashMap<>();
4        for (int stone : stones) {
5            dp.put(stone, new HashSet<>());
6        }
7        dp.get(0).add(0);
8
9        for (int stone : stones) {
10            for (int jump : dp.get(stone)) {
11                for (int jumpDistance : new int[] {jump - 1, jump, jump + 1}) {
12                    if (jumpDistance > 0 && dp.containsKey(stone + jumpDistance)) {
13                        dp.get(stone + jumpDistance).add(jumpDistance);
14                    }
15                }
16            }
17        }
18
19        return !dp.get(stones[stones.length - 1]).isEmpty();        
20    }
21}
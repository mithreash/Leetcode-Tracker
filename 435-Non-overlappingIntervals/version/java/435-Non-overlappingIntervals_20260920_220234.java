// Last updated: 9/20/2026, 10:02:34 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int pathSum(TreeNode root, int targetSum) {
18        Map<Long,Integer> prefixMap = new HashMap<>();
19        prefixMap.put(0L,1);
20        return dfs(root,0,targetSum,prefixMap);
21    }
22
23    int dfs(TreeNode node, long sum, int target, Map<Long,Integer> prefixMap) {
24        if(node==null) return 0;
25        sum += node.val;
26
27        int count = prefixMap.getOrDefault(sum - target, 0);
28
29        prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
30
31        count += dfs(node.left, sum, target, prefixMap);
32        count += dfs(node.right, sum, target, prefixMap);
33
34        prefixMap.put(sum, prefixMap.get(sum) - 1);
35
36        return count;
37    }
38}
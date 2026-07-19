// Last updated: 7/19/2026, 3:27:13 PM
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
17    public List<Integer> postorderTraversal(TreeNode root) {
18        List<Integer> result = new ArrayList<>();
19        fun(root, result);
20        return result;
21    }
22    public static void fun(TreeNode root, List<Integer> result){
23        if(root != null){
24            fun(root.left, result);
25            fun(root.right, result);
26            result.add(root.val);
27        }
28    }
29}
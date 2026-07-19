// Last updated: 7/19/2026, 9:01:58 AM
1class Solution {
2    private int dominantCount = 0;
3    public int countDominantNodes(TreeNode root){
4        dominantCount = 0;
5        traverse(root);
6        return dominantCount;
7    }
8    private int traverse(TreeNode node){
9        if(node == null){
10            return Integer.MIN_VALUE;
11        }
12        int leftMax =  traverse(node.left);
13        int rightMax = traverse(node.right);
14        int currentSubtreeMax = Math.max(node.val,Math.max(leftMax , rightMax));
15        if (node.val == currentSubtreeMax){
16            dominantCount++;
17        }
18        return currentSubtreeMax;
19    }
20}
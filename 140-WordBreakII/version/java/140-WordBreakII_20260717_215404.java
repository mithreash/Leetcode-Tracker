// Last updated: 7/17/2026, 9:54:04 PM
1class Solution {
2    private TreeNode first = null;
3    private TreeNode second = null;
4    private TreeNode prev = null;
5    public void recoverTree(TreeNode root) {
6        inorder(root);
7        int temp = first.val;
8        first.val = second.val;
9        second.val = temp;
10    }
11    private void inorder(TreeNode node) {
12        if (node == null) return;
13        inorder(node.left);
14        if (prev != null && prev.val > node.val) {
15            if (first == null) {
16                first = prev;
17            }
18            second = node;
19        }
20        prev = node;
21        inorder(node.right);
22    }
23}
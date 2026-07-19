// Last updated: 7/19/2026, 3:23:46 PM
1class Solution {
2    List<Integer> preorderTraverse(TreeNode root,List<Integer> list) {
3
4        if(root==null)
5            return list;
6        list.add(root.val);
7        preorderTraverse(root.left,list);
8        preorderTraverse(root.right,list);
9        return list;
10    }
11    public List<Integer> preorderTraversal(TreeNode root) {
12        List<Integer> list = new ArrayList<Integer>();
13        list = preorderTraverse(root,list);
14        return list;
15    }
16}
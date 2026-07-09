// Last updated: 7/9/2026, 3:07:56 PM
class Solution {
    public int minDepth(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       if(root == null){
        return 0;
       }
       q.add(root);
       q.add(null);
       int depth = 0;
       while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    depth++;
                    q.add(null);
                }
            }else{
                if(curr.left == null && curr.right == null){
                    depth++;
                    return depth;
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
       }

       return 0;
    }
}
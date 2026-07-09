// Last updated: 7/9/2026, 3:08:09 PM
class Solution {
    private long minVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; 
        if (!isValidBST(root.left)) return false;
        
        if (minVal >= root.val) return false; 

        minVal = root.val;

        if (!isValidBST(root.right)) return false;

        return true;
    } 
}
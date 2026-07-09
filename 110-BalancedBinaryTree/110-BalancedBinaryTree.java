// Last updated: 7/9/2026, 3:07:57 PM

class Solution {

    public boolean isBalanced(TreeNode root) {
        return heightDiff(root) != -1;
    }

    public int heightDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int hleft = heightDiff(root.left);
        if (hleft == -1)
            return -1;
        int hright = heightDiff(root.right);
        if (hright == -1)
            return -1;

        if (Math.abs(hleft - hright) > 1) {
            return -1;
        }
        return 1 + Math.max(hleft, hright);
    }
}
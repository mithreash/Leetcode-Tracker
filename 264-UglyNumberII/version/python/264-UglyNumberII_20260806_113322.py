# Last updated: 8/6/2026, 11:33:22 AM
1# Definition for a binary tree node.
2# class TreeNode:
3#     def __init__(self, val=0, left=None, right=None):
4#         self.val = val
5#         self.left = left
6#         self.right = right
7class Solution:
8    def rob(self, root: Optional[TreeNode]) -> int:
9        def dfs(curr):
10            if curr is None:
11                return 0, 0
12
13            left = dfs(curr.left)
14            right = dfs(curr.right)
15
16            rob = curr.val + left[1] + right[1]  # Rob now means can't rob its children.
17            skip = max(left[0], left[1]) + max(right[0], right[1])
18
19            return rob, skip
20        return max(dfs(root))
// Last updated: 8/3/2026, 3:35:43 PM
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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> list = new ArrayList<>();
19        if(root == null){
20            return list;
21        }
22
23        Queue<TreeNode> queue = new LinkedList<>();  // stored the level node
24        queue.offer(root);
25
26        while(!queue.isEmpty()){
27            int size = queue.size(); // number of node in node.
28            
29            for(int i = 0; i < size; i++){
30                TreeNode current = queue.poll();
31
32                // i == size - 1 --> current are pointing the last node which are present in the queue
33                if(i == size - 1){ 
34                    list.add(current.val); // add the last node val in list.
35                }
36
37                if(current.left != null){
38                    queue.offer(current.left);
39                }
40                if(current.right != null){
41                    queue.offer(current.right);
42                }
43            }
44        }
45        return list;
46    }
47}
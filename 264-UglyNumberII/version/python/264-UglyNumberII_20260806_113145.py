# Last updated: 8/6/2026, 11:31:45 AM
1class Solution:
2    def isValidSerialization(self, preorder: str) -> bool:
3        # Initialize the outDegree (children) - inDegree (parent) to 1
4        degree = 1
5        
6        # Iterate through the nodes in the preorder traversal
7        for node in preorder.split(','):
8            degree -= 1 # Decrement the degree by 1 for each node
9            
10            if degree < 0: # If the degree is negative, return False
11                return False
12            
13            if node != '#': # If the node is not a leaf node
14                degree += 2 # Increment the degree by 2 for each non-leaf node
15            
16        # If the final degree is 0, the tree is valid, else invalid
17        return degree == 0
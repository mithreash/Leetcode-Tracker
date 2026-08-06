# Last updated: 8/6/2026, 11:14:53 AM
1from collections import defaultdict, deque
2from typing import List
3
4class Solution:
5    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
6        
7        # Edge case: single node
8        if n == 1:
9            return [0]
10
11        # Adjacency list
12        adj = defaultdict(list)
13        degree = [0] * n
14
15        # Build graph
16        for u, v in edges:
17            adj[u].append(v)
18            adj[v].append(u)
19            degree[u] += 1
20            degree[v] += 1
21
22        # Queue of leaf nodes
23        q = deque()
24
25        # Push initial leaf nodes
26        for i in range(n):
27            if degree[i] == 1:
28                q.append(i)
29
30        nodes = n
31
32        # Trim leaves layer by layer
33        while nodes > 2:
34            size = len(q)
35            nodes -= size
36
37            for _ in range(size):
38                curr = q.popleft()
39
40                for nei in adj[curr]:
41                    degree[nei] -= 1
42
43                    # If it becomes a leaf
44                    if degree[nei] == 1:
45                        q.append(nei)
46
47        # Remaining nodes are MHT roots
48        return list(q)
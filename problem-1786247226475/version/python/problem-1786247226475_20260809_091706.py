# Last updated: 8/9/2026, 9:17:06 AM
1class Solution:
2    def weightedSum(self, parent: list[int], nums: list[int]) -> int:
3        n = len(parent)
4        if n == 0:
5            return 0
6        adj = defaultdict(list)
7        root = 0
8        for child in range(1,n):
9            if parent[child] == -1:
10                root = child
11            else:
12                adj[parent[child]].append(child)
13        depth_map = [0] * n
14        queue = deque([(root, 1)])
15        max_depth = 1
16        while queue:
17            node,d = queue.popleft()
18            depth_map[node] = d
19            if d > max_depth:
20                max_depth = d
21            for child in adj[node]:
22                queue.append((child,d + 1))
23        total_weight = 0
24        for i in range(n):
25            total_weight += nums[i] * (max_depth - depth_map[i] + 1 )
26        return total_weight
27        
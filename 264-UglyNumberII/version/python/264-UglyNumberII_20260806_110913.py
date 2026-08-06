# Last updated: 8/6/2026, 11:09:13 AM
1class Codec:
2    def serialize(self, root):
3        if not root: return "null"
4        res, q = [], deque([root])
5        while q:
6            node = q.popleft()
7            if node:
8                res.append(str(node.val))
9                q.append(node.left)
10                q.append(node.right)
11            else:
12                res.append("null")
13        return ','.join(res)
14
15    def deserialize(self, data):
16        if data == "null": return None
17        nodes = data.split(',')
18        root = TreeNode(int(nodes[0]))
19        q = deque([root])
20        i = 1
21        while q:
22            curr = q.popleft()
23            if nodes[i] != "null":
24                curr.left = TreeNode(int(nodes[i]))
25                q.append(curr.left)
26            i += 1
27            if i < len(nodes) and nodes[i] != "null":
28                curr.right = TreeNode(int(nodes[i]))
29                q.append(curr.right)
30            i += 1
31        return root
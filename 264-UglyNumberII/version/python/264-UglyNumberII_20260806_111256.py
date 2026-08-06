# Last updated: 8/6/2026, 11:12:56 AM
1# Segment tree node
2class Node(object):
3    def __init__(self, start, end):
4        self.start = start
5        self.end = end
6        self.total = 0
7        self.left = None
8        self.right = None
9
10
11class NumArray(object):
12
13    def __init__(self, nums):
14        # helper function to create the tree from input array
15        def createTree(nums, l, r):
16
17            # base case
18            if l > r:
19                return None
20
21            # leaf node
22            if l == r:
23                n = Node(l, r)
24                n.total = nums[l]
25                return n
26
27            mid = (l + r) // 2
28
29            root = Node(l, r)
30
31            # recursively build the Segment tree
32            root.left = createTree(nums, l, mid)
33            root.right = createTree(nums, mid + 1, r)
34
35            # Total stores the sum of all leaves under root
36            # i.e. those elements lying between (start, end)
37            root.total = root.left.total + root.right.total
38
39            return root
40
41        self.root = createTree(nums, 0, len(nums) - 1)
42
43    def update(self, i, val):
44        # Helper function to update a value
45        def updateVal(root, i, val):
46
47            # Base case. The actual value will be updated in a leaf.
48            # The total is then propogated upwards
49            if root.start == root.end:
50                root.total = val
51                return val
52
53            mid = (root.start + root.end) // 2
54
55            # If the index is less than the mid, that leaf must be in the left subtree
56            if i <= mid:
57                updateVal(root.left, i, val)
58
59            # Otherwise, the right subtree
60            else:
61                updateVal(root.right, i, val)
62
63            # Propogate the changes after recursive call returns
64            root.total = root.left.total + root.right.total
65
66            return root.total
67
68        return updateVal(self.root, i, val)
69
70    def sumRange(self, i, j):
71        # Helper function to calculate range sum
72        def rangeSum(root, i, j):
73
74            # If the range exactly matches the root, we already have the sum
75            if root.start == i and root.end == j:
76                return root.total
77
78            mid = (root.start + root.end) // 2
79
80            # If end of the range is less than the mid, the entire interval lies
81            # in the left subtree
82            if j <= mid:
83                return rangeSum(root.left, i, j)
84
85            # If start of the interval is greater than mid, the entire inteval lies
86            # in the right subtree
87            elif i >= mid + 1:
88                return rangeSum(root.right, i, j)
89
90            # Otherwise, the interval is split. So we calculate the sum recursively,
91            # by splitting the interval
92            else:
93                return rangeSum(root.left, i, mid) + rangeSum(
94                    root.right, mid + 1, j
95                )
96
97        return rangeSum(self.root, i, j)
98
99# Your NumArray object will be instantiated and called as such:
100# obj = NumArray(nums)
101# obj.update(index,val)
102# param_2 = obj.sumRange(left,right)
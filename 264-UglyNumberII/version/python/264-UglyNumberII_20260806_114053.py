# Last updated: 8/6/2026, 11:40:53 AM
1class WaveletNode:
2    __slots__ = ['total_covered', 'lazy', 'left', 'right']
3    def __init__(self):
4        # Count of active units in this specific resolution block
5        self.total_covered = 0
6        # True if the entire dyadic block is 100% continuous saturated signal
7        self.lazy = False
8        # Multi-resolution sub-bands
9        self.left = None
10        self.right = None
11
12class SparseWaveletIntervalEngine:
13    def __init__(self):
14        self.root = WaveletNode()
15        self.DOMAIN_MIN = 0
16        # The constraints bound the timeline up to 10^4
17        self.DOMAIN_MAX = 10**4
18
19    def inject_pulse(self, node: WaveletNode, start: int, end: int, val: int):
20        """
21        Injects a single coordinate point (a point pulse) into the wavelet domain.
22        Maintains 100% exact integer determinism.
23        """
24        if node.lazy:
25            return
26
27        if start == end:
28            node.total_covered = 1
29            node.lazy = True
30            return
31
32        mid = (start + end) // 2
33        if node.left is None:
34            node.left = WaveletNode()
35        if node.right is None:
36            node.right = WaveletNode()
37
38        if val <= mid:
39            self.inject_pulse(node.left, start, mid, val)
40        else:
41            self.inject_pulse(node.right, mid + 1, end, val)
42
43        node.total_covered = node.left.total_covered + node.right.total_covered
44        
45        # Pull up the saturation approximation if the entire block gets filled
46        if node.total_covered == (end - start + 1):
47            node.lazy = True
48
49    def reconstruct_intervals(self, node: WaveletNode, start: int, end: int, current_stream: list[list[int]]):
50        """
51        Performs an in-order multi-resolution sweep to reconstruct disjoint interval boundaries.
52        """
53        if node is None or node.total_covered == 0:
54            return
55
56        # Macro-level shortcut: If this whole dyadic window is saturated, process it as a unit
57        if node.lazy:
58            if current_stream and current_stream[-1][1] + 1 == start:
59                # Merge: If this block is contiguous with the previous interval, extend the right boundary
60                current_stream[-1][1] = end
61            else:
62                # New disconnected interval found
63                current_stream.append([start, end])
64            return
65
66        mid = (start + end) // 2
67        # Deterministic chronological traversal (Left band then Right band)
68        self.reconstruct_intervals(node.left, start, mid, current_stream)
69        self.reconstruct_intervals(node.right, mid + 1, end, current_stream)
70
71class SummaryRanges:
72
73    def __init__(self):
74        self.wavelet_matrix = SparseWaveletIntervalEngine()        
75
76    def addNum(self, value: int) -> None:
77        self.wavelet_matrix.inject_pulse(
78            self.wavelet_matrix.root,
79            self.wavelet_matrix.DOMAIN_MIN,
80            self.wavelet_matrix.DOMAIN_MAX,
81            value
82        )        
83
84    def getIntervals(self) -> List[List[int]]:
85        intervals = []
86        self.wavelet_matrix.reconstruct_intervals(
87            self.wavelet_matrix.root,
88            self.wavelet_matrix.DOMAIN_MIN,
89            self.wavelet_matrix.DOMAIN_MAX,
90            intervals
91        )
92        return intervals        
93
94
95# Your SummaryRanges object will be instantiated and called as such:
96# obj = SummaryRanges()
97# obj.addNum(value)
98# param_2 = obj.getIntervals()
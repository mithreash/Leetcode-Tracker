# Last updated: 8/6/2026, 11:08:43 AM
1import heapq
2
3class MedianFinder:
4    def __init__(self):
5        self.lowerHalf = []  # max-heap (store negatives)
6        self.upperHalf = []  # min-heap
7
8    def addNum(self, num: int) -> None:
9        heapq.heappush(self.lowerHalf, -num)
10
11        # Balance largest of lowerHalf into upperHalf
12        heapq.heappush(self.upperHalf, -heapq.heappop(self.lowerHalf))
13
14        # Maintain size property
15        if len(self.upperHalf) > len(self.lowerHalf):
16            heapq.heappush(self.lowerHalf, -heapq.heappop(self.upperHalf))
17
18    def findMedian(self) -> float:
19        if len(self.lowerHalf) > len(self.upperHalf):
20            return -self.lowerHalf[0]
21        return (-self.lowerHalf[0] + self.upperHalf[0]) / 2.0
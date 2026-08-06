# Last updated: 8/6/2026, 11:16:38 AM
1import heapq
2class Solution:
3    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
4        heap = [1]
5        visited = set([1])
6
7        count = 0
8
9        while heap:
10            val = heapq.heappop(heap)
11            count += 1
12
13            if count == n:
14                return val
15
16            for mult in primes:
17                nxt = val * mult
18
19                if nxt not in visited:
20                    visited.add(nxt)
21                    heapq.heappush(heap, nxt)
# Last updated: 8/6/2026, 11:36:44 AM
1class Solution:
2    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
3        hashmap=defaultdict(int)
4        for i in nums:
5                hashmap[i]+=1
6        hashmap = list(sorted(hashmap.items(), key=lambda x: x[1],reverse=True))
7
8        output=[i[0] for i in hashmap[:k]]
9        return output
10
11        
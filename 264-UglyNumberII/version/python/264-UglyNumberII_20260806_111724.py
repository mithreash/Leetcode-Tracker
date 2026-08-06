# Last updated: 8/6/2026, 11:17:24 AM
1class Solution:
2    def countSmaller(self, nums: List[int]) -> List[int]:
3        n=len(nums)
4        unique=sorted(set(nums))
5        mapp={}
6        for i,val in enumerate(unique):
7            mapp[val]=i+1
8        tree=[0]*(n+1)
9        def query(i):
10            ans=0
11            while i>0:
12                ans+=tree[i]
13                i-=i&(-i)
14            return ans
15
16        def update(i,val):
17            while i<=n:
18                tree[i]+=val
19                i+=i&(-i)
20        ans=[0]*n
21        for i in range(n-1,-1,-1):
22            rank=mapp[nums[i]]
23            ans[i]=query(rank-1)
24            update(rank,1)
25        return ans
26
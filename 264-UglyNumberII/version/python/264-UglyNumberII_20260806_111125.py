# Last updated: 8/6/2026, 11:11:25 AM
1class NumArray:
2
3    def __init__(self, nums: List[int]):
4        self.nums = nums
5        
6
7    def sumRange(self, left: int, right: int) -> int:
8        total = 0
9        for i in range(left,right+1):
10            total += self.nums[i]
11        return total
12        
13
14
15# Your NumArray object will be instantiated and called as such:
16# obj = NumArray(nums)
17# param_1 = obj.sumRange(left,right)
# Last updated: 8/6/2026, 11:07:14 AM
1class Solution:
2    def findDuplicate(self, nums: List[int]) -> int:
3        slow = nums[0]
4        fast = nums[0]
5        
6        while True:
7            slow = nums[slow]
8            fast = nums[nums[fast]]
9            if slow == fast:
10                break
11        
12        slow2 = nums[0]
13        while slow != slow2:
14            slow = nums[slow]
15            slow2 = nums[slow2]
16
17        return slow
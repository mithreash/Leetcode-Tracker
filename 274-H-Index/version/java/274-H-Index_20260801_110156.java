// Last updated: 8/1/2026, 11:01:56 AM
1class Solution {
2    public void moveZeroes(int[] nums) 
3   {
4        int i = 0;
5        for (int num : nums)
6        {
7            if (num != 0)
8            {
9                nums[i] = num;
10                i++;
11            }
12        }
13
14        while (i <= nums.length - 1)
15        {
16            nums[i] = 0;
17            i++;
18        }
19
20    }
21}
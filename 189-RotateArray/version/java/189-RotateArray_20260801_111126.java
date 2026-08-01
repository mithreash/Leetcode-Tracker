// Last updated: 8/1/2026, 11:11:26 AM
1class Solution {
2    public void rotate(int[] nums, int k) {
3        k %= nums.length;
4        reverse(nums, 0, nums.length-1);
5        reverse(nums, 0, k-1);
6        reverse(nums, k, nums.length-1);
7    }
8
9    public void reverse(int[] nums, int start, int end){
10        while(start < end){
11            int temp = nums[start];
12            nums[start] = nums[end];
13            nums[end] = temp;
14            start++;
15            end--;
16        }
17    }
18}
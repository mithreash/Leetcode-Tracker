// Last updated: 7/9/2026, 3:09:47 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1, ans = -1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] >= target) r = m - 1;
            else l = m + 1;

            if (nums[m] == target) ans = m;
        }

        return ans;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1, ans = -1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] <= target) l = m + 1;
            else r = m - 1;

            if (nums[m] == target) ans = m;
        }

        return ans;
    }
}
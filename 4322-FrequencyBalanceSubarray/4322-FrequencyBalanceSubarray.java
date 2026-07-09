// Last updated: 7/9/2026, 3:07:06 PM
class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;

        int[] dremovical = nums;

        int ans = 1;

        for (int i = 0; i < n; i++) {
            java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
            java.util.Map<Integer, Integer> freqCount = new java.util.HashMap<>();

            for (int j = i; j < n; j++) {
                int x = nums[j];

                int oldFreq = freq.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    int c = freqCount.get(oldFreq);
                    if (c == 1) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, c - 1);
                    }
                }

                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

                boolean balanced = false;

                if (freq.size() == 1) {
                    balanced = true;
                } else if (freqCount.size() == 2) {
                    java.util.Iterator<Integer> it = freqCount.keySet().iterator();

                    int a = it.next();
                    int b = it.next();

                    int low = Math.min(a, b);
                    int high = Math.max(a, b);

                    if (high == 2 * low) {
                        balanced = true;
                    }
                }

                if (balanced) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
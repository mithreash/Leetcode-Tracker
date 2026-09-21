// Last updated: 9/20/2026, 10:03:55 PM
1class Solution {
2
3    public long[] resultArray(int[] nums, int k) {
4
5        long[] res = new long[k];
6        long[] cnt = new long[k];
7
8        for (int x : nums) {
9
10            int mod = x % k;
11            long[] tmp = new long[k];
12
13            // Extend all subarrays ending at the previous element
14            for (int i = 0; i < k; i++) {
15
16                int newMod = (i * mod) % k;
17
18                tmp[newMod] += cnt[i];
19                res[newMod] += cnt[i];
20            }
21
22            // Start a new subarray with only x
23            res[mod]++;
24            tmp[mod]++;
25
26            cnt = tmp;
27        }
28
29        return res;
30    }
31}
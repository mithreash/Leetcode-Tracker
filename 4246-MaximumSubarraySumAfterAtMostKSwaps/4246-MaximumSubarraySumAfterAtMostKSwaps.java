// Last updated: 7/9/2026, 3:06:56 PM
import java.util.*;

class Solution {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;

        int[] vals = nums.clone();
        Arrays.sort(vals);

        int m = 0;
        for (int x : vals) {
            if (m == 0 || vals[m - 1] != x) vals[m++] = x;
        }

        long ans = Long.MIN_VALUE;

        for (int l = 0; l < n; l++) {
            Fenwick inCnt = new Fenwick(m);
            Fenwick inSum = new Fenwick(m);
            Fenwick outCnt = new Fenwick(m);
            Fenwick outSum = new Fenwick(m);

            for (int x : nums) {
                int id = lowerBound(vals, m, x) + 1;
                outCnt.add(id, 1);
                outSum.add(id, x);
            }

            long base = 0;
            int inside = 0;
            int outside = n;

            for (int r = l; r < n; r++) {
                int id = lowerBound(vals, m, nums[r]) + 1;

                outCnt.add(id, -1);
                outSum.add(id, -nums[r]);
                outside--;

                inCnt.add(id, 1);
                inSum.add(id, nums[r]);
                inside++;

                base += nums[r];

                int limit = Math.min(k, Math.min(inside, outside));

                int low = 0, high = limit;

                while (low < high) {
                    int mid = (low + high + 1) / 2;

                    int smallId = inCnt.kth(mid);
                    int largeId = outCnt.kth(outside - mid + 1);

                    if (vals[largeId - 1] > vals[smallId - 1]) {
                        low = mid;
                    } else {
                        high = mid - 1;
                    }
                }

                int t = low;
                long gain = 0;

                if (t > 0) {
                    long smallInside = sumSmallest(inCnt, inSum, vals, t);
                    long largeOutside = outSum.sum(m) - sumSmallest(outCnt, outSum, vals, outside - t);
                    gain = largeOutside - smallInside;
                }

                ans = Math.max(ans, base + gain);
            }
        }

        return ans;
    }

    private long sumSmallest(Fenwick cnt, Fenwick sum, int[] vals, int t) {
        if (t <= 0) return 0;

        int id = cnt.kth(t);
        long beforeCnt = cnt.sum(id - 1);
        long beforeSum = sum.sum(id - 1);

        return beforeSum + (long)(t - beforeCnt) * vals[id - 1];
    }

    private int lowerBound(int[] arr, int len, int target) {
        int l = 0, r = len;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    static class Fenwick {
        int n;
        long[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;

            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }

            return res;
        }

        int kth(long k) {
            int idx = 0;
            int mask = Integer.highestOneBit(n);

            while (mask != 0) {
                int next = idx + mask;

                if (next <= n && bit[next] < k) {
                    idx = next;
                    k -= bit[next];
                }

                mask >>= 1;
            }

            return idx + 1;
        }
    }
}
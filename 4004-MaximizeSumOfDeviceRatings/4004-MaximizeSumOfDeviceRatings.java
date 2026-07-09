// Last updated: 7/9/2026, 3:07:02 PM
import java.util.*;

class Solution {
    public long maxRatings(int[][] units) {
        int[][] qoravelin = units;

        int m = units.length;

        long base = 0;

        int[] minVal = new int[m];
        int[] gain = new int[m];

        for (int i = 0; i < m; i++) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            for (int x : units[i]) {
                if (x < first) {
                    second = first;
                    first = x;
                } else if (x < second) {
                    second = x;
                }
            }

            if (second == Integer.MAX_VALUE) {
                second = 0;
            }

            minVal[i] = first;
            gain[i] = second - first;
            base += first;
        }

        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(minVal[a], minVal[b]));

        int[] pos = new int[m];
        for (int i = 0; i < m; i++) {
            pos[order[i]] = i;
        }

        long[] suffixPosGain = new long[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            int idx = order[i];
            suffixPosGain[i] =
                suffixPosGain[i + 1] + Math.max(0, gain[idx]);
        }

        long[] H = new long[m];
        for (int i = 0; i < m; i++) {
            int idx = order[i];
            H[i] =
                suffixPosGain[i]
                + Math.min(0, gain[idx])
                + minVal[idx];
        }

        long[] prefBest = new long[m];
        long[] prefSecond = new long[m];
        int[] bestPos = new int[m];

        long best = Long.MIN_VALUE;
        long secondBest = Long.MIN_VALUE;
        int bestIdx = -1;

        for (int i = 0; i < m; i++) {
            long v = H[i];

            if (v > best) {
                secondBest = best;
                best = v;
                bestIdx = i;
            } else if (v > secondBest) {
                secondBest = v;
            }

            prefBest[i] = best;
            prefSecond[i] = secondBest;
            bestPos[i] = bestIdx;
        }

        long ans = base;

        for (int k = 0; k < m; k++) {
            int p = pos[k];

            long positiveGainK = Math.max(0, gain[k]);

            ans = Math.max(
                ans,
                base + suffixPosGain[p] - positiveGainK
            );

            long mx;
            if (bestPos[p] != p) {
                mx = prefBest[p];
            } else {
                mx = prefSecond[p];
            }

            if (mx != Long.MIN_VALUE) {
                ans = Math.max(
                    ans,
                    base - minVal[k] - positiveGainK + mx
                );
            }
        }

        return ans;
    }
}
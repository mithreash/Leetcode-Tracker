// Last updated: 8/3/2026, 3:16:42 PM
1class Solution {
2     private int[] bit;
3    private int size;
4
5    private void update(int pos) {
6        while (pos <= size) {
7            bit[pos]++;
8            pos += pos & (-pos);
9        }
10    }
11
12    private int query(int pos) {
13        int s = 0;
14        while (pos > 0) {
15            s += bit[pos];
16            pos -= pos & (-pos);
17        }
18        return s;
19    }
20    public long countRatioSubarrays(int[] nums, int a, int b) {
21        int n = nums.length;
22        int[] O = new int[n + 1];
23        for (int i = 1; i <= n; i++) {
24            O[i] = O[i - 1] + (nums[i - 1] % 2);
25        }
26
27        long[] f = new long[n + 1];
28        long A = a, B = b;
29        for (int i = 0; i <= n; i++) {
30            f[i] = B * i - (A + B) * O[i];
31        }
32
33        long[] sortedUnique = f.clone();
34        Arrays.sort(sortedUnique);
35        int m = 0;
36        for (int i = 0; i < sortedUnique.length; i++) {
37            if (i == 0 || sortedUnique[i] != sortedUnique[m - 1]) {
38                sortedUnique[m++] = sortedUnique[i];
39            }
40        }
41
42        int[] rank = new int[n + 1];
43        for (int i = 0; i <= n; i++) {
44            int lo = 0, hi = m - 1, pos = -1;
45            while (lo <= hi) {
46                int mid = (lo + hi) / 2;
47                if (sortedUnique[mid] == f[i]) {
48                    pos = mid;
49                    break;
50                } else if (sortedUnique[mid] < f[i]) {
51                    lo = mid + 1;
52                } else {
53                    hi = mid - 1;
54                }
55            }
56            rank[i] = pos + 1;
57        }
58
59        size = m;
60        bit = new int[size + 1];
61
62        long ans = 0;
63        int totalInserted = 0;
64        int i = 0;
65        while (i <= n) {
66            int j = i;
67            while (j <= n && O[j] == O[i]) {
68                j++;
69            }
70
71            for (int r = i; r < j; r++) {
72                int rk = rank[r];
73                int cnt = totalInserted - query(rk - 1);
74                ans += cnt;
75            }
76
77            for (int l = i; l < j; l++) {
78                update(rank[l]);
79                totalInserted++;
80            }
81
82            i = j;
83        }
84
85        return ans;
86    }
87    
88}
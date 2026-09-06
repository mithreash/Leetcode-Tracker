// Last updated: 9/6/2026, 10:10:58 AM
1import java.util.PriorityQueue;
2
3class Solution {
4    public int trapRainWater(int[][] height) {
5        int n = height.length;
6        int m = height[0].length;
7
8        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
9        boolean[][] vis = new boolean[n][m];
10
11        // Add first and last column
12        for (int i = 0; i < n; i++) {
13            vis[i][0] = true;
14            vis[i][m - 1] = true;
15            pq.offer(new int[]{height[i][0], i, 0});
16            pq.offer(new int[]{height[i][m - 1], i, m - 1});
17        }
18
19        // Add first and last row
20        for (int i = 0; i < m; i++) {
21            vis[0][i] = true;
22            vis[n - 1][i] = true;
23            pq.offer(new int[]{height[0][i], 0, i});
24            pq.offer(new int[]{height[n - 1][i], n - 1, i});
25        }
26
27        int ans = 0;
28        int[] dr = {-1, 0, 1, 0};
29        int[] dc = {0, -1, 0, 1};
30
31        while (!pq.isEmpty()) {
32            int[] curr = pq.poll();
33            int h = curr[0], r = curr[1], c = curr[2];
34
35            for (int i = 0; i < 4; i++) {
36                int nr = r + dr[i];
37                int nc = c + dc[i];
38
39                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
40                    ans += Math.max(0, h - height[nr][nc]);
41                    pq.offer(new int[]{Math.max(h, height[nr][nc]), nr, nc});
42                    vis[nr][nc] = true;
43                }
44            }
45        }
46
47        return ans;
48    }
49}
// Last updated: 8/1/2026, 11:07:43 AM
1class Solution {
2
3    static class Node implements Comparable<Node> {
4        int r, c, p;
5        long d;
6
7        Node(int r, int c, int p, long d) {
8            this.r = r;
9            this.c = c;
10            this.p = p;
11            this.d = d;
12        }
13
14        public int compareTo(Node o) {
15            return Long.compare(this.d, o.d);
16        }
17    }
18
19    public long minCost(int m, int n, int[][] penalty) {
20        long INF = Long.MAX_VALUE / 4;
21        long[][][] dist = new long[m][n][2];
22
23        for (int i = 0; i < m; i++) {
24            for (int j = 0; j < n; j++) {
25                dist[i][j][0] = INF;
26                dist[i][j][1] = INF;
27            }
28        }
29
30        PriorityQueue<Node> pq = new PriorityQueue<>();
31
32        dist[0][0][0] = 1;
33        pq.offer(new Node(0, 0, 0, 1));
34
35        int[] dr = { 0, 1, 0, -1 };
36        int[] dc = { 1, 0, -1, 0 };
37
38        while (!pq.isEmpty()) {
39            Node curr = pq.poll();
40
41            if (curr.d != dist[curr.r][curr.c][curr.p])
42                continue;
43
44            int np = curr.p ^ 1;
45
46            long nd = curr.d + penalty[curr.r][curr.c];
47            if (nd < dist[curr.r][curr.c][np]) {
48                dist[curr.r][curr.c][np] = nd;
49                pq.offer(new Node(curr.r, curr.c, np, nd));
50            }
51
52            for (int k = 0; k < 4; k++) {
53                int nr = curr.r + dr[k];
54                int nc = curr.c + dc[k];
55
56                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
57                    continue;
58
59                boolean followsRule;
60
61                if (curr.p == 0) {
62                    followsRule = (k == 0 || k == 1);
63                } else {
64                    followsRule = (k == 2 || k == 3);
65                }
66
67                long cost = curr.d + (long) (nr + 1) * (nc + 1);
68
69                if (!followsRule) {
70                    cost += penalty[curr.r][curr.c];
71                }
72
73                if (cost < dist[nr][nc][np]) {
74                    dist[nr][nc][np] = cost;
75                    pq.offer(new Node(nr, nc, np, cost));
76                }
77            }
78        }
79
80        return Math.min(dist[m - 1][n - 1][0], dist[m - 1][n - 1][1]);
81    }
82}
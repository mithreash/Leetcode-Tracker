// Last updated: 9/16/2026, 2:14:21 PM
1class Solution {
2
3    static class Pair {
4        String node;
5        double weight;
6
7        Pair(String node, double weight) {
8            this.node = node;
9            this.weight = weight;
10        }
11    }
12
13    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
14        HashMap<String, List<Pair>> graph = new HashMap<>();
15
16        for (int i = 0; i < equations.size(); i++) {
17            String u = equations.get(i).get(0);
18            String v = equations.get(i).get(1);
19            double w = values[i];
20
21            graph.putIfAbsent(u, new ArrayList<>());
22            graph.putIfAbsent(v, new ArrayList<>());
23
24            graph.get(u).add(new Pair(v, w));
25            graph.get(v).add(new Pair(u, 1.0 / w));
26        }
27
28        double[] ans = new double[queries.size()];
29
30        for (int i = 0; i < queries.size(); i++) {
31            String src = queries.get(i).get(0);
32            String dest = queries.get(i).get(1);
33
34            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
35                ans[i] = -1.0;
36                continue;
37            }
38
39            if (src.equals(dest)) {
40                ans[i] = 1.0;
41                continue;
42            }
43
44            HashSet<String> visited = new HashSet<>();
45            ans[i] = dfs(src, dest, graph, visited);
46
47        }
48
49        return ans;
50    }
51
52    private double dfs(String curr, String target, HashMap<String, List<Pair>> graph, HashSet<String> visited) {
53        if (curr.equals(target))
54            return 1.0;
55
56        visited.add(curr);
57
58        for (Pair next : graph.get(curr)) {
59            if (visited.contains(next.node))
60                continue;
61
62            double ans = dfs(next.node, target, graph, visited);
63
64            if (ans != -1.0)
65                return next.weight * ans;
66        }
67
68        return -1.0;
69    }
70}
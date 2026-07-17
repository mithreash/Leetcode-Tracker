// Last updated: 7/17/2026, 9:42:06 PM
1class Solution {
2    private void helper(String s, int i, Set<String> dict, List<String> cur, List<String> res) {
3        if (i == s.length()) {
4            if (cur.size() > 0) {
5                StringBuilder sb = new StringBuilder();
6                for (int j = 0; j < cur.size(); j++) {
7                    if (j > 0) {
8                        sb.append(' ');
9                    }
10                    sb.append(cur.get(j));
11                }
12                res.add(sb.toString());
13            }
14            return;
15        }
16
17        for (int j = i+1; j <= s.length(); j++) {
18            if (dict.contains(s.substring(i, j))) {
19                cur.add(s.substring(i, j));
20                helper(s, j, dict, cur, res);
21                cur.remove(cur.size() - 1);
22            }
23        }
24    }
25    public List<String> wordBreak(String s, List<String> wordDict) {
26        Set<String> dict = new HashSet<>(wordDict);
27        List<String> res = new ArrayList<>();
28        List<String> cur = new ArrayList<>();
29        helper(s, 0, dict, cur, res);
30        return res;
31    }
32}
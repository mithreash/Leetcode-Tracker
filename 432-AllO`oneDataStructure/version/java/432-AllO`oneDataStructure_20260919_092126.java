// Last updated: 9/19/2026, 9:21:26 AM
1class Solution {
2
3    public int minMutation(String startGene, String endGene, String[] bank) {
4
5        HashSet<String> set = new HashSet<>();
6        for (String gene : bank) {
7            set.add(gene);
8        }
9
10        if (!set.contains(endGene))
11            return -1;
12
13        Queue<String> q = new LinkedList<>();
14        HashSet<String> visited = new HashSet<>();
15
16        char[] chars = { 'A', 'C', 'G', 'T' };
17
18        q.offer(startGene);
19        visited.add(startGene);
20
21        int mutations = 0;
22
23        while (!q.isEmpty()) {
24
25            int size = q.size();
26
27            while (size-- > 0) {
28
29                String curr = q.poll();
30
31                if (curr.equals(endGene))
32                    return mutations;
33
34                char[] arr = curr.toCharArray();
35
36                for (int i = 0; i < 8; i++) {
37
38                    char original = arr[i];
39
40                    for (char ch : chars) {
41
42                        if (ch == original)
43                            continue;
44
45                        arr[i] = ch;
46                        String next = new String(arr);
47
48                        if (set.contains(next) && !visited.contains(next)) {
49                            visited.add(next);
50                            q.offer(next);
51                        }
52                    }
53
54                    arr[i] = original;
55                }
56            }
57
58            mutations++;
59        }
60
61        return -1;
62    }
63}
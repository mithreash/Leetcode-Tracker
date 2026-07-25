// Last updated: 7/25/2026, 1:24:06 PM
1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        if (!wordList.contains(endWord)) return 0;
4
5        Set<String> set = new HashSet<>(wordList);
6        Queue<String> q = new LinkedList<>();
7
8        q.offer(beginWord);
9        set.remove(beginWord); // Remove starting word if present.
10
11        int count = 1;
12
13        while (!q.isEmpty()) {
14            int size = q.size();
15
16            for (int i = 0; i < size; i++) {
17                String word = q.poll();
18                char[] curr = word.toCharArray();
19
20                for (int j = 0; j < word.length(); j++) {
21                    char original = curr[j];
22
23                    for (char ch = 'a'; ch <= 'z'; ch++) {
24                        curr[j] = ch;
25                        String str = new String(curr);
26
27                        if (set.contains(str)) {
28                            if (str.equals(endWord)) {
29                                return count + 1;
30                            }
31
32                            q.offer(str);
33                            set.remove(str);
34                        }
35                    }
36
37                    curr[j] = original;
38                }
39            }
40
41            count++;
42        }
43
44        return 0;
45    }
46}
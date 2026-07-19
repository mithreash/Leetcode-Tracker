// Last updated: 7/19/2026, 2:07:03 PM
1class Solution {
2    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
3        List<List<String>> ans = new ArrayList<>(); 
4        Map<String, Set<String>> reverse = new HashMap<>(); // reverse graph start from endWord
5        Set<String> wordSet = new HashSet<>(wordList); // remove the duplicate words
6        wordSet.remove(beginWord); // remove the first word to avoid cycle path
7        Queue<String> queue = new LinkedList<>(); // store current layer nodes
8        queue.add(beginWord); // first layer has only beginWord
9        Set<String> nextLevel = new HashSet<>(); // store nextLayer nodes
10        boolean findEnd = false; // find endWord flag
11        while (!queue.isEmpty()) { // traverse current layer nodes
12            String word = queue.remove();
13            for (String next : wordSet) {
14                if (isLadder(word, next)) { // is ladder words
15					// construct the reverse graph from endWord
16                    Set<String> reverseLadders = reverse.computeIfAbsent(next, k -> new HashSet<>());
17                    reverseLadders.add(word); 
18                    if (endWord.equals(next)) {
19                        findEnd = true;
20                    }
21                    nextLevel.add(next); // store next layer nodes
22                }
23            }
24            if (queue.isEmpty()) { // when current layer is all visited
25                if (findEnd) break; // if find the endWord, then break the while loop
26                queue.addAll(nextLevel); // add next layer nodes to queue
27                wordSet.removeAll(nextLevel); // remove all next layer nodes in wordSet
28                nextLevel.clear();
29            }
30        }
31        if (!findEnd) return ans; // if can't reach endWord from startWord, then return ans.
32        Set<String> path = new LinkedHashSet<>();
33        path.add(endWord);
34		// traverse reverse graph from endWord to beginWord
35        findPath(endWord, beginWord, reverse, ans, path); 
36        return ans;
37    }
38
39
40    private void findPath(String endWord, String beginWord, Map<String, Set<String>> graph,
41                                 List<List<String>> ans, Set<String> path) {
42        Set<String> next = graph.get(endWord);
43        if (next == null) return;
44        for (String word : next) {
45            path.add(word);
46            if (beginWord.equals(word)) {
47                List<String> shortestPath = new ArrayList<>(path);
48                Collections.reverse(shortestPath); // reverse words in shortest path
49                ans.add(shortestPath); // add the shortest path to ans.
50            } else {
51                findPath(word, beginWord, graph, ans, path);
52            }
53            path.remove(word);
54        }
55    }
56
57    private boolean isLadder(String s, String t) {
58        if (s.length() != t.length()) return false;
59        int diffCount = 0;
60        int n = s.length();
61        for (int i = 0; i < n; i++) {
62            if (s.charAt(i) != t.charAt(i)) diffCount++;
63            if (diffCount > 1) return false;
64        }
65        return diffCount == 1;
66    }
67}
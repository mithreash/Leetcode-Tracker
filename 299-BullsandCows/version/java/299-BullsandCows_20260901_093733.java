// Last updated: 9/1/2026, 9:37:33 AM
1class Solution {
2    public String getHint(String secret, String guess) {
3        int n = secret.length();
4        Map<Character, Integer> map = new HashMap<>();
5
6        int bulls = 0;
7        int cows = 0;
8
9        for(int i=0; i<n; i++) {
10            char s = secret.charAt(i);
11            char g = guess.charAt(i);
12
13            if(s == g) {
14                bulls++;
15            } else {
16                map.put(s, map.getOrDefault(s, 0) + 1);
17            }
18        }
19
20        for(int i=0; i<n; i++) {
21            char s = secret.charAt(i);
22            char g = guess.charAt(i);
23
24            if(s != g && map.getOrDefault(g, 0) > 0) {
25                cows++;
26                map.put(g, map.get(g) - 1);
27            }
28        }
29
30        return bulls + "A" + cows + "B";
31    }
32} 
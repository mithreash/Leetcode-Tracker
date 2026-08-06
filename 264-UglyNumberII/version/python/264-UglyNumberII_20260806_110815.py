# Last updated: 8/6/2026, 11:08:15 AM
1class Solution:
2    def wordPattern(self, pattern: str, s: str) -> bool:
3        words = s.split(" ")
4        if len(pattern) != len(words):
5            return False
6        
7        seen = {}
8
9        for p, w in zip(pattern, words):
10            key_p = ("p", p)
11            key_w = ("w", w)
12
13            if key_p in seen and seen[key_p] != w:
14                return False
15            if key_w in seen and seen[key_w] != p:
16                return False
17            
18            seen[key_p] = w
19            seen[key_w] = p
20        
21        return True
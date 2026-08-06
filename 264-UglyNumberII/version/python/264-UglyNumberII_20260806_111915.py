# Last updated: 8/6/2026, 11:19:15 AM
1class Solution:
2    def maxProduct(self, words: List[str]) -> int:
3        n=len(words)                        
4        char_set = [set(words[i]) for i in range(n)] # precompute hashset for each word                                                  
5        max_val = 0
6        for i in range(n):
7            for j in range(i+1, n):
8                if not (char_set[i] & char_set[j]): # if nothing common
9                    max_val=max(max_val, len(words[i]) * len(words[j]))
10        
11        return max_val   
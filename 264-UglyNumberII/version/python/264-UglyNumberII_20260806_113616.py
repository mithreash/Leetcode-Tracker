# Last updated: 8/6/2026, 11:36:16 AM
1class Solution:
2    def reverseVowels(self, s: str) -> str:
3        vowel=[]
4        for w in s:
5            if w in "aeiouAEIOU":
6                vowel.append(w)
7        res=""
8        for w in s:
9            if w in "aeiouAEIOU":
10                res+=vowel.pop()#pop(-1)🤩NO need vowel[::-1]!!!
11            else:
12                res+=w
13        return res
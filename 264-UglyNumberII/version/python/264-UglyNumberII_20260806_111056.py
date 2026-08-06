# Last updated: 8/6/2026, 11:10:56 AM
1class Solution:
2    def removeInvalidParentheses(self, s: str) -> List[str]:
3        ## RC ##
4        ## APPROACH : BACK-TRACKING ##
5        ## Similar to Leetcode 32. Longest Valid Parentheses ##
6        ## LOGIC ##
7        #   1. use stack to find invalid left and right braces.
8        #   2. if its close brace at index i , you can remove it directly to make it valid and also you can also remove any of the close braces before that i.e in the range [0,i-1]
9        #   3. similarly for open brace, left over at index i, you can remove it or any other open brace after that i.e [i+1, end]
10        #   4. if left over braces are more than 1 say 2 close braces here, you need to make combinations of all 2 braces before that index and find valid parentheses.
11        #   5. so, we count left and right invalid braces and do backtracking removing them
12        
13		## TIME COMPLEXITY : O(2^N) ## (each brace has 2 options: exits or to be removed)
14		## SPACE COMPLEXITY : O(N) ##
15
16        def isValid(s):
17            stack = []
18            for i in range(len(s)):
19                if( s[i] == '(' ):
20                    stack.append( (i,'(') )
21                elif( s[i] == ')' ):
22                    if(stack and stack[-1][1] == '('):
23                        stack.pop()
24                    else:
25                        stack.append( (i,')') )         # pushing invalid close braces also
26            return len(stack) == 0, stack
27        
28        
29        def dfs( s, left, right):
30            visited.add(s)
31            if left == 0 and right == 0 and isValid(s)[0]:  res.append(s)
32            for i, ch in enumerate(s):
33                if ch != '(' and ch != ')': continue                                    # if it is any other char ignore.
34                if (ch == '(' and left == 0) or (ch == ')' and right == 0): continue    # if left == 0 then removing '(' will only cause imbalance. Hence, skip.
35                if s[:i] + s[i+1:] not in visited:
36                    dfs( s[:i] + s[i+1:], left - (ch == '('), right - (ch == ')') )
37        
38        stack = isValid(s)[1]
39        lc = sum([1 for val in stack if val[1] == "("]) # num of left braces
40        rc = len(stack) - lc
41        
42        res, visited = [], set()
43        dfs(s, lc, rc)
44        return res
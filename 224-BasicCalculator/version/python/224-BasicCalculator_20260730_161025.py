# Last updated: 7/30/2026, 4:10:25 PM
1class Solution:
2    def calculate(self, s: str) -> int:
3        st = []
4
5        ans = 0
6        num = 0
7        sign = 1
8
9        for ch in s:
10
11            if ch.isdigit():
12                num = num * 10 + int(ch)
13
14            elif ch == '+':
15                ans += sign * num
16                num = 0
17                sign = 1
18
19            elif ch == '-':
20                ans += sign * num
21                num = 0
22                sign = -1
23
24            elif ch == '(':
25                st.append(ans)
26                st.append(sign)
27
28                ans = 0
29                sign = 1
30
31            elif ch == ')':
32                ans += sign * num
33                num = 0
34
35                prevSign = st.pop()
36                prevAns = st.pop()
37
38                ans = prevAns + prevSign * ans
39
40        ans += sign * num
41
42        return ans
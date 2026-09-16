// Last updated: 9/16/2026, 9:33:33 AM
1class Solution {
2    int i = 0;
3    public String decodeString(String s) {
4        i = 0;
5        return decode(s);
6    }
7    private String decode(String s) {
8        StringBuilder res = new StringBuilder();
9        int num = 0;
10        while (i < s.length()) {
11            char c = s.charAt(i);
12            if (Character.isDigit(c)) {
13                num = num * 10 + (c - '0');
14                i++;
15            } else if (c == '[') {
16                i++;
17                String inner = decode(s);
18                for (int k = 0; k < num; k++) res.append(inner);
19                num = 0;
20            } else if (c == ']') {
21                i++;
22                return res.toString();
23            } else {
24                res.append(c);
25                i++;
26            }
27        }
28        return res.toString();
29    }
30}
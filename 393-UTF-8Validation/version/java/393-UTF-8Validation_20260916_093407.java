// Last updated: 9/16/2026, 9:34:07 AM
1public class Solution {
2    public int longestSubstring(String s, int k) {
3        if (s == null || s.length() == 0) return 0;
4        char[] chars = new char[26];
5        // record the frequency of each character
6        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
7        boolean flag = true;
8        for (int i = 0; i < chars.length; i += 1) {
9            if (chars[i] < k && chars[i] > 0) flag = false;
10        }
11        // return the length of string if this string is a valid string
12        if (flag == true) return s.length();
13        int result = 0;
14        int start = 0, cur = 0;
15        // otherwise we use all the infrequent elements as splits
16        while (cur < s.length()) {
17            if (chars[s.charAt(cur) - 'a'] < k) {
18                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
19                start = cur + 1;
20            }
21            cur++;
22        }
23        result = Math.max(result, longestSubstring(s.substring(start), k));
24        return result;
25    }
26}
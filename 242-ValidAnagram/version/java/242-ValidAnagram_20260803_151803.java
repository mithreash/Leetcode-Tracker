// Last updated: 8/3/2026, 3:18:03 PM
1public class Solution {
2    public boolean isAnagram(String s, String t) {
3        int[] alphabet = new int[26];
4        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
5        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
6        for (int i : alphabet) if (i != 0) return false;
7        return true;
8    }
9}
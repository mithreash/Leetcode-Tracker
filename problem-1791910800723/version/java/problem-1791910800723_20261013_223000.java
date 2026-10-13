// Last updated: 10/13/2026, 10:30:00 PM
1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        int[] arr = new int[26];
4        
5        for (char ch : magazine.toCharArray()) {
6            arr[ch - 'a']++;
7        }
8        
9        for (char ch : ransomNote.toCharArray()) {
10            arr[ch - 'a']--;
11        }
12        
13        for (int count : arr) {
14            if (count < 0) {
15                return false;
16            }
17        }
18        
19        return true;
20    }
21}
// Last updated: 7/19/2026, 1:23:59 PM
1public class Solution {
2	public boolean isScramble(String s1, String s2) {
3		if (s1.length() != s2.length()) return false;
4		int len = s1.length();
5		
6		boolean [][][] F = new boolean[len][len][len + 1];
7		for (int k = 1; k <= len; ++k)
8			for (int i = 0; i + k <= len; ++i)
9				for (int j = 0; j + k <= len; ++j)
10					if (k == 1)
11						F[i][j][k] = s1.charAt(i) == s2.charAt(j);
12					else for (int q = 1; q < k && !F[i][j][k]; ++q) {
13						F[i][j][k] = (F[i][j][q] && F[i + q][j + q][k - q]) || (F[i][j + k - q][q] && F[i + q][j][k - q]);
14					}
15		return F[0][0][len];
16	}
17}
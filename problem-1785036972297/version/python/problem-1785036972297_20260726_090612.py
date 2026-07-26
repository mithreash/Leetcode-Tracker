# Last updated: 7/26/2026, 9:06:12 AM
1class Solution(object):
2    def countValidSequences(self, n: int, k: int) -> int:
3        MOD = 10**9 + 7 
4        if n < k :
5            return 0
6        total_sequences = math.comb(n-1,k-1)
7        all_odd_sequences = 0
8        if (n - k) % 2 == 0:
9            remaining_sum = (n-k) // 2
10            all_odd_sequences = math.comb(remaining_sum + k - 1, k - 1)
11        ans = (total_sequences - all_odd_sequences) % MOD
12        return ans
13        
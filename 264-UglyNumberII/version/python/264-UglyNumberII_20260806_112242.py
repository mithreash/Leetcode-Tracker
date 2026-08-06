# Last updated: 8/6/2026, 11:22:42 AM
1class Solution:
2    def coinChange(self, coins: List[int], amount: int) -> int:
3        min_coins = [amount + 1] * (amount + 1)
4        min_coins[0] = 0
5
6        for i in range(1, amount + 1):
7            for c in coins:
8                if i - c >= 0:
9                    min_coins[i] = min(min_coins[i], 1 + min_coins[i - c])
10        
11        return min_coins[-1] if min_coins[-1] != amount + 1 else -1
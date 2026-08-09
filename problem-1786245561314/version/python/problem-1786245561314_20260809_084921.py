# Last updated: 8/9/2026, 8:49:21 AM
1class Solution:
2    def minPrice(self, prices: list[int], discounts: list[int]) -> float:
3        prices.sort(reverse=True)
4        discounts.sort(reverse=True)
5        total_sum = 0.0
6        for i in range(len(prices)):
7            if i < len(discounts):
8                discount_percentage = discounts[i]
9                total_sum += prices[i] * (100 - discount_percentage) / 100.0
10            else:
11                total_sum  += prices[i]
12        return total_sum
13        
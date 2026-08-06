# Last updated: 8/6/2026, 11:13:26 AM
1class Solution:
2    def maxProfit(self, prices: List[int]) -> int:
3        
4		# initialization
5        cool_down, sell, hold = 0, 0, -float('inf')
6        
7        for stock_price_of_Day_i in prices:
8            
9            prev_cool_down, prev_sell, prev_hold = cool_down, sell, hold
10            
11            # Max profit of cooldown on Day i comes from either cool down of Day_i-1, or sell out of Day_i-1 and today Day_i is cooling day
12            cool_down = max(prev_cool_down, prev_sell)
13            
14            # Max profit of sell on Day_i comes from hold of Day_i-1 and sell on Day_i
15            sell = prev_hold + stock_price_of_Day_i
16            
17            # Max profit of hold on Day_i comes from either hold of Day_i-1, or cool down on Day_i-1 and buy on Day_i
18            hold = max(prev_hold, prev_cool_down - stock_price_of_Day_i)
19        
20        
21        # The action of final trading day must be either sell or cool down
22        return max(sell, cool_down)
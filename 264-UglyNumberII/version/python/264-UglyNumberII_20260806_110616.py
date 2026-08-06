# Last updated: 8/6/2026, 11:06:16 AM
1class Solution:
2    def nthUglyNumber(self, n: int) -> int:
3        # Set to store potential ugly numbers
4        ugly_numbers_set = set()
5        # Start with 1, the first ugly number
6        ugly_numbers_set.add(1)
7
8        current_ugly = 1
9        for i in range(n):
10            # Get the smallest number from the set
11            current_ugly = min(ugly_numbers_set)
12            # Remove it from the set
13            ugly_numbers_set.remove(current_ugly)
14
15            # Insert the next potential ugly numbers
16            ugly_numbers_set.add(current_ugly * 2)
17            ugly_numbers_set.add(current_ugly * 3)
18            ugly_numbers_set.add(current_ugly * 5)
19
20        # Return the nth ugly number
21        return current_ugly
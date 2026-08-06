# Last updated: 8/6/2026, 11:12:32 AM
1class Solution:
2    def isAdditiveNumber(self, num: str) -> bool:
3        n = len(num)
4        
5        # check if the sequence is valid starting from the first two numbers
6        for i in range(1, n):
7            for j in range(i+1, n):
8                # if the first two numbers have leading zeros, move on to the next iteration
9                if num[0] == "0" and i > 1:
10                    break
11                if num[i] == "0" and j > i+1:
12                    break
13                    
14                # initialize the first two numbers and check if the sequence is valid
15                num1 = int(num[:i])
16                num2 = int(num[i:j])
17                k = j
18                while k < n:
19                    # calculate the next number in the sequence and check if it matches the remaining string
20                    num3 = num1 + num2
21                    if num[k:].startswith(str(num3)):
22                        k += len(str(num3))
23                        num1 = num2
24                        num2 = num3
25                    else:
26                        break
27                if k == n:
28                    return True
29                
30        # if no valid sequence is found, return False
31        return False
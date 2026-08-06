# Last updated: 8/6/2026, 11:18:16 AM
1class Solution:
2    def removeDuplicateLetters(self, s: str) -> str:
3        # Dictionary to store the last occurrence of each character
4        last_occur = {}
5
6        # Record the last occurrence of each character
7        for i, char in enumerate(s):
8            last_occur[char] = i        
9
10        stack = []  # Stack to store characters in the desired order
11        visited = set()  # Set to keep track of visited characters
12
13        for i in range(len(s)):
14            if s[i] in visited:
15                continue  # Skip if the character is already visited
16
17            # If the top of the stack is greater than s[i] and will occur later again, remove from stack
18            while stack and s[i] < stack[-1] and i < last_occur.get(stack[-1], -1):
19                visited.remove(stack.pop())
20
21            visited.add(s[i])  # Mark as visited
22            stack.append(s[i])  # Add to the stack
23        
24        return ''.join(stack)  # Concatenate the characters remaining in the stack
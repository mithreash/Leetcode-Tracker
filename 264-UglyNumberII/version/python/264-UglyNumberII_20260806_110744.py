# Last updated: 8/6/2026, 11:07:44 AM
1from typing import List
2
3class Solution:
4    def gameOfLife(self, board: List[List[int]]) -> None:
5        n, m = len(board), len(board[0])
6        
7        # Directions for neighbors
8        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
9
10        # First pass: **Mark** temporary state changes
11        for i in range(n):
12            for j in range(m):
13                live_neighbors = 0
14                for dx, dy in directions:
15                    ni, nj = i + dx, j + dy
16                    
17                    if 0 <= ni < n and 0 <= nj < m:
18                        # Check if neighbor was originally live
19                        if board[ni][nj] in [1, 2]:
20                            live_neighbors += 1
21
22                if board[i][j] == 1: # Current cell is live
23                    if live_neighbors < 2 or live_neighbors > 3:
24                        board[i][j] = 2 # live -> dead
25                else: # Current cell is dead
26                    if live_neighbors == 3:
27                        board[i][j] = 3 # dead -> live
28
29        # Second pass: **Finalize** state changes
30        for i in range(n):
31            for j in range(m):
32                if board[i][j] == 2:
33                    board[i][j] = 0 # Finalize live -> dead
34                elif board[i][j] == 3:
35                    board[i][j] = 1 # Finalize dead -> live
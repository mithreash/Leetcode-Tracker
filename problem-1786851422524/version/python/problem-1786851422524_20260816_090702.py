# Last updated: 8/16/2026, 9:07:02 AM
1class Solution:
2    def nearestDrone(self, drones: list[list[int]], target: list[int]) -> int:
3        tx,ty = target
4        min_distance = float('inf')
5        best_index = -1
6        for i, (x,y,r) in enumerate(drones):
7            distance = abs(x - tx) + abs(y - ty)
8            if distance <= r :
9                if distance < min_distance:
10                    min_distance = distance
11                    best_index = i
12        return best_index
13        
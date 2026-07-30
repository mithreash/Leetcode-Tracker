# Last updated: 7/30/2026, 4:11:57 PM
1class MyStack:
2
3    def __init__(self):
4        self.q = deque()
5
6    def push(self, x: int) -> None:
7        self.q.append(x)
8        for _ in range(len(self.q) - 1):
9            self.q.append(self.q.popleft())
10
11    def pop(self) -> int:
12        return self.q.popleft()
13        
14    def top(self) -> int:
15        return self.q[0]
16
17    def empty(self) -> bool:
18        return len(self.q) == 0
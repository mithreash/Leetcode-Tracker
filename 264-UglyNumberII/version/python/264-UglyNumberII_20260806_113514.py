# Last updated: 8/6/2026, 11:35:14 AM
1class NestedIterator:
2    def __init__(self, nestedList: [NestedInteger]):
3        self.stack = []
4        # Add the nestedList to the stack in reverse order
5        for i in range(len(nestedList) - 1, -1, -1):
6            self.stack.append(nestedList[i])        
7    
8    def next(self) -> int:
9        return self.stack.pop().getInteger()        
10    
11    def hasNext(self) -> bool:
12        # Flatten the list by popping elements from the stack until we find an integer
13        while self.stack:
14            current = self.stack[-1]
15            if current.isInteger():
16                return True
17
18            # If it's a list, pop it and push its elements in reverse order
19            self.stack.pop()
20            nested_list = current.getList()
21            for i in range(len(nested_list) - 1, -1, -1):
22                self.stack.append(nested_list[i])
23
24        return False         
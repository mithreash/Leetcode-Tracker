// Last updated: 7/19/2026, 12:29:15 PM
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3
4        Stack<Integer> stack = new Stack<>();
5        int maxArea = 0;
6        int n = heights.length;
7
8        for (int i = 0; i <= n; i++) {
9
10            // Virtual bar of height 0 to flush the stack
11            int currentHeight = (i == n) ? 0 : heights[i];
12
13            // Current bar is smaller,
14            // so waiting bars can no longer extend right.
15            while (!stack.isEmpty() &&
16                   currentHeight < heights[stack.peek()]) {
17
18                int height = heights[stack.pop()];
19
20                // After popping:
21                // i = first smaller bar on the right
22                // stack.peek() = first smaller bar on the left
23                int width = stack.isEmpty()
24                        ? i
25                        : i - stack.peek() - 1;
26
27                maxArea = Math.max(maxArea, height * width);
28            }
29
30            stack.push(i);
31        }
32
33        return maxArea;
34    }
35}
// Last updated: 9/16/2026, 3:00:44 PM
1class Solution {
2    public String removeKdigits(String num, int k) {
3
4        Deque<Character> stack = new ArrayDeque<>();
5        int count = 0;
6
7        // remove the k digit 
8        for (int i = 0; i < num.length(); i++) {
9
10            while (!stack.isEmpty() && stack.peek() > num.charAt(i)) {
11                if (count < k) {
12                    stack.poll();
13                    count++;
14                }else break ;
15            }
16
17            stack.push(num.charAt(i));
18        }
19
20        // remove the remainging digit .. 
21        while (count < k) {
22            stack.pop();
23            count++;
24        }
25        if (stack.isEmpty())
26            return "0";
27
28        // create the ans string and appen char 
29        StringBuilder sb = new StringBuilder();
30        while (!stack.isEmpty()) {
31            sb.append(stack.pollLast());
32        }
33
34
35        // remove lead zero 
36        int indx = 0;
37        while (indx < sb.length()-1  && sb.charAt(indx) == '0') {
38            indx++;
39        }
40
41        return sb.toString().substring(indx);
42    }
43}
// Last updated: 9/6/2026, 9:40:40 AM
1class Solution {
2    int[][] best;
3    public int getMoneyAmount(int n) {
4        best = new int[n + 1][n + 1];
5        for (int i = 0; i < n + 1; i++) {
6            Arrays.fill(best[i], -1);
7        }
8        return dp(1, n);
9    }
10    
11    private int dp(int lo, int hi) {
12        if (lo >= hi) {
13            return 0;
14        } else {
15            if (best[lo][hi] != -1) {
16                return best[lo][hi];
17            }
18            //the idea is to  compute the maximum amount of money I need to pay with my guesses ranging from lo to hi.
19            //Since I want to minimize my payoff, I'll choose the starting point [lo,hi] that has the minimum payoff.
20            //But for each starting point, I'll choose the maximum amount of money I pay, since I need the worst case scenario.
21            int res = Integer.MAX_VALUE;
22            for (int i = lo; i <= hi; i++) {
23                int op1 = 0; //guess = i, i was correct, no cost incurred
24                int op2 = i + dp(lo, i - 1);//guess = i = wrong, go lo
25                int op3 = i + dp(i + 1, hi);//guess = i = wrong, go hi
26                int out = Math.max(op1, Math.max(op2, op3));
27                res = Math.min(out, res);
28            }
29            best[lo][hi] = res;
30            return res;
31        }
32    }       
33}
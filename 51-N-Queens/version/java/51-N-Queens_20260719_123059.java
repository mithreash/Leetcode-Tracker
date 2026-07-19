// Last updated: 7/19/2026, 12:30:59 PM
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<List<String>> ans = new ArrayList<>();
4        boolean[] cols = new boolean[n + 1];
5        boolean[] ndiag = new boolean[2 * n - 1];
6        boolean[] rdiag = new boolean[2 * n - 1];
7        boolean[][] board = new boolean[n][n];
8        queen(n, 0, board, ndiag, rdiag, cols,  ans);
9        return ans;
10    }
11
12    List<String> constructboard(boolean[][] board) {
13        ArrayList<String> list = new ArrayList<>();
14        for (int i = 0; i < board.length; i++) {
15            StringBuilder sb = new StringBuilder();
16            for (int j = 0; j < board[0].length; j++) {
17                if (board[i][j]) {
18                    sb.append("Q");
19                } else {
20                    sb.append(".");
21                }
22            }
23            list.add(sb.toString());
24        }
25        return list;
26    }
27
28    void queen(int n, int row, boolean[][] board, boolean[] ndiag, boolean[] rdiag, boolean[] cols,    List<List<String>> ans) {
29        //base case
30        if (row == board.length) {// base case should be board.length because the index should also be counted
31            ans.add(new ArrayList<>(constructboard(board)));
32            return;
33        }
34        for (int col = 0; col < board.length; col++) {
35            if (cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] == false) {
36                if (board[row][col] == false) {
37                    board[row][col] = true;
38                    cols[col] = true;
39                    ndiag[row + col] = true;
40                    rdiag[row - col + board.length - 1] = true;
41                    queen(n, row + 1, board, ndiag, rdiag, cols,  ans);
42                    board[row][col] = false;
43                    cols[col] = false;
44                    ndiag[row + col] = false;
45                    rdiag[row - col + board.length - 1] = false;
46                }
47            }
48        }
49    }
50}
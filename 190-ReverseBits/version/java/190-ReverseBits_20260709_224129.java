// Last updated: 7/9/2026, 10:41:29 PM
1class Solution {
2  public List<List<Integer>> generate(int numRows) {
3    List<List<Integer>> ans = new ArrayList<>();
4
5    for (int i = 0; i < numRows; ++i) {
6      Integer[] temp = new Integer[i + 1];
7      Arrays.fill(temp, 1);
8      ans.add(Arrays.asList(temp));
9    }
10
11    for (int i = 2; i < numRows; ++i)
12      for (int j = 1; j < ans.get(i).size() - 1; ++j)
13        ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
14
15    return ans;
16  }
17}
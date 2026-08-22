// Last updated: 8/22/2026, 9:44:02 AM
1class Solution {
2    public List<List<Integer>> combinationSum3(int k, int n) {
3        List<List<Integer>> arr = new ArrayList<>();
4
5        res(1, arr, new ArrayList<>(), k, n);
6
7        return arr;
8    }
9
10    void res(int idx, List<List<Integer>> arr, List<Integer> chk, int k, int n){
11        if(chk.size()==k){
12            if(n==0){
13                arr.add(new ArrayList<>(chk));
14            }
15            return;
16        }
17
18        for(int i=idx; i<10; i++){
19            chk.add(i);
20            res(i+1, arr, chk, k, n-i);
21            chk.remove(chk.size()-1);
22        }
23    }
24}
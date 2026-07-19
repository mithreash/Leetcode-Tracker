// Last updated: 7/19/2026, 3:22:23 PM
1class Solution {
2    public void form(int[] nums,int start,int size,List<List<Integer>>result){
3        if(start == size){  
4            List<Integer> ans = new ArrayList<>();
5            for (int ele : nums) ans.add(ele);
6            result.add(ans);
7            return;
8        }
9
10        HashSet<Integer> set = new HashSet<>();
11        for(int i =start;i<size;i++){
12            if(set.contains(nums[i])) continue;
13
14            set.add(nums[i]);
15            int temp = nums[start];
16            nums[start] = nums[i];
17            nums[i] = temp;
18
19            form(nums,start+1,size,result);
20
21            temp = nums[start];
22            nums[start] = nums[i];
23            nums[i] = temp;
24        }
25    }
26
27    public List<List<Integer>> permuteUnique(int[] nums) {
28        int n = nums.length;
29        List<List<Integer>> result = new ArrayList<>();        
30        form(nums,0,n,result);
31        return result;
32    }
33}
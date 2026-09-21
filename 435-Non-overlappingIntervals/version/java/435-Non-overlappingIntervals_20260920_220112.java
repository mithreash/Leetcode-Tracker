// Last updated: 9/20/2026, 10:01:12 PM
1class Solution {
2    public int[] findRightInterval(int[][] intv) {
3        int n=intv.length;
4        int [][] arr=new int[n][3];
5
6        for(int i=0;i<n;i++){
7           
8            arr[i][0]=intv[i][0];
9             arr[i][1]=intv[i][1];
10              arr[i][2]=i;
11        }
12
13
14        Arrays.sort(arr,(a,b)->a[0]-b[0]);
15
16int ans[]=new int[n];
17         for(int i=0;i<n;i++){
18
19            ans[arr[i][2]]=binaryseach(arr,i,n-1,arr[i][1]);
20         }
21        
22
23        return ans;
24    }
25
26    public int binaryseach(int [][] arr,int low,int high,int target){
27
28        
29         int result = -1; 
30
31        while (low <= high) {
32            int mid = low + (high - low) / 2;
33
34            if (arr[mid][0] >= target) {
35                result = arr[mid][2];  
36                high = mid - 1;
37            } else {
38                low = mid + 1;
39            }
40        }
41        return result;
42
43
44    }
45}
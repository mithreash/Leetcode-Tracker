// Last updated: 9/21/2026, 10:03:15 PM
1class Solution {
2    public int findKthNumber(int n, int k) {
3        int prefix=1;
4        for(int count=1;count<k;){
5            int currCount=getCountWithPrefix(prefix,prefix+1,n);
6            if(currCount+count<=k){
7                count+=currCount;
8                prefix++;
9            }else{
10                prefix*=10;
11                count++;
12            }
13        }
14        return prefix;
15    }
16    private int getCountWithPrefix(long startPrefix,long endPrefix,int max){
17        int count=0;
18        while(startPrefix<=max){
19            count+=Math.min(max+1,endPrefix)-startPrefix;
20            startPrefix*=10;
21            endPrefix*=10;
22        }
23        return count;
24    }
25}
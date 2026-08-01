// Last updated: 8/1/2026, 9:07:31 AM
1class Solution {
2    public int hIndex(int[] citations) 
3    {
4        int l=0;
5        int h=citations.length-1;
6        int n=citations.length;
7        int ans=0;
8        while(l<=h)
9        {
10            int mid=l+(h-l)/2;
11            if(citations[mid]>=n-mid)
12            {
13                ans=n-mid;
14                h=mid-1;
15            }
16            else
17            {
18                l=mid+1;
19            }
20        }
21        return ans;
22    }
23//please upvote;
24}
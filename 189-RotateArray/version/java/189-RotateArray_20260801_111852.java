// Last updated: 8/1/2026, 11:18:52 AM
1class Solution {
2    static int solveTab(int[] prices,int k){
3        int n=prices.length;
4
5        int [][] curr = new int[2][k+2];
6        int [][] next = new int[2][k+2];
7
8        for(int index=n-1;index>=0;index--){
9            for(int buy=1;buy>=0;buy--){
10                for(int limit=1;limit<=k;limit++){
11                    int profit=0;
12                    if(buy==1){
13                        int salekaro=prices[index]+next[0][limit-1];
14                        int skipkaro=0+next[1][limit];
15                        profit+=Math.max(salekaro,skipkaro);
16                    }
17                    else{
18                        int buykaro=-prices[index]+next[1][limit];
19                        int skipkaro=0+next[0][limit];
20                        profit+=Math.max(buykaro,skipkaro);
21                    }
22                    curr[buy][limit]=profit;
23                }
24            }
25            next=curr;
26        }
27        return next[0][k];
28    }
29    public int maxProfit(int k, int[] prices) {
30        return solveTab(prices,k);
31    }
32}
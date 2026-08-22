// Last updated: 8/22/2026, 9:42:22 AM
1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
4        for(int val:nums)pq.offer(val);
5        while(k-->1&&!pq.isEmpty())pq.poll();
6        return pq.peek();
7    }
8}
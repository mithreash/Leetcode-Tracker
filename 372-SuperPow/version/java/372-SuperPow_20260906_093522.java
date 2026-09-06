// Last updated: 9/6/2026, 9:35:22 AM
1class Solution {
2    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
3        List<List<Integer>> list = new ArrayList<>();
4        
5        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
6
7        for(int x : nums1) {
8            pq.offer(new int[] {x + nums2[0], 0});
9        }
10
11        while(k > 0 && !pq.isEmpty()) {
12            int[] pair = pq.poll();
13            int sum = pair[0];
14            int pos = pair[1];
15
16            list.add(List.of(sum - nums2[pos], nums2[pos]));
17
18            if(pos + 1 < nums2.length) {
19                pq.offer(new int[] {sum - nums2[pos] + nums2[pos + 1], pos + 1});
20            }
21            k--;
22        }
23 
24        return list;
25    }
26
27}
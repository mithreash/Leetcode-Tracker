// Last updated: 10/13/2026, 10:28:40 PM
1class Solution {
2    ArrayList<Integer> list = new ArrayList<>();
3    public Solution(ListNode head) {
4        while(head!=null){
5            list.add(head.val);
6            head=head.next;
7        }
8    }
9    
10    public int getRandom() {
11        double rand=Math.random()*list.size();
12        return list.get((int)rand);
13    }
14}
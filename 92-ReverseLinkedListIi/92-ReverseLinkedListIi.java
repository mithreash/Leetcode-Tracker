// Last updated: 7/9/2026, 3:08:17 PM
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //beforeLeftNode => bL
        //leftNode => lN 
        if(head.next == null || left == right) return head;

        //finding bL and lN
        ListNode bL = head, lN = head;
        for(int i = 1; i < left; i++) {
            bL = lN;
            lN = lN.next;
        }

        //reverse logic
        ListNode curr = head, prev = null;
        for(int i = 1; i <= right; i++) {
            if(i >= left) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }

        //edge case : when left == 1
        if(left == 1) {
            head = prev;
        }else {
            bL.next = prev;
        }


        lN.next = curr;
        return head;
    }
}
// Last updated: 7/9/2026, 3:08:26 PM

class Solution {
    public ListNode partition(ListNode head, int x) {
        // Step 1: Initialize dummy nodes to build independent streams safely 🛡️
        ListNode list1 = new ListNode(0); // Holds nodes < x
        ListNode list2 = new ListNode(0); // Holds nodes >= x
        ListNode s = list1;               // Runner for the smaller list
        ListNode b = list2;               // Runner for the larger list

        ListNode temp = head;
        
        // Step 2: Route nodes to their respective chains 🔀
        while (temp != null) {
            if (temp.val < x) {
                s.next = temp;
                s = s.next;
            } else {
                b.next = temp;
                b = b.next;
            }
            temp = temp.next;
        }

        // Step 3: Stitch the two chains together 🪡
        s.next = list2.next;
        
        // Step 4: Securely break any remaining old connections to prevent cycles ✂️
        b.next = null;

        // Return the head of the sorted partition past the initial dummy node
        return list1.next;
    }
}
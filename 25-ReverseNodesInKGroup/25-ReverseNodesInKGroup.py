# Last updated: 7/9/2026, 3:10:04 PM
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        group_prev = dummy

        while True:
            kth = self.getKth(group_prev, k)
            if not kth:
                break

            group_next = kth.next

            prev = group_next
            curr = group_prev.next

            while curr != group_next:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp

            tmp = group_prev.next
            group_prev.next = kth
            group_prev = tmp

        return dummy.next

    def getKth(self, curr, k):
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr
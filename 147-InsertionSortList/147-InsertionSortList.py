# Last updated: 7/9/2026, 3:07:49 PM
class Solution:
    def insertionSortList(self, head):
        dummy = ListNode(0)
        current = head

        while current:
            prev = dummy

            while prev.next and prev.next.val < current.val:
                prev = prev.next

            next_node = current.next
            current.next = prev.next
            prev.next = current
            current = next_node

        return dummy.next
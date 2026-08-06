# Last updated: 8/6/2026, 11:31:14 AM
1# Definition for singly-linked list.
2# class ListNode(object):
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution(object):
7    def oddEvenList(self, head):
8        """
9        :type head: ListNode
10        :rtype: ListNode
11        """
12        if head == None or head.next == None : return head 
13        odd = ListNode(0) 
14        odd_ptr = odd
15        even = ListNode(0)
16        even_ptr = even 
17        idx = 1 
18        while head != None :
19            if idx % 2 == 0:
20                even_ptr.next = head
21                even_ptr = even_ptr.next
22            else:
23                odd_ptr.next = head
24                odd_ptr = odd_ptr.next
25            head = head.next
26            idx+=1
27        even_ptr.next = None
28        odd_ptr.next = even.next
29        return odd.next
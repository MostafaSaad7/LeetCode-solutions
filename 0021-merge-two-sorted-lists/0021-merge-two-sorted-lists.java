
class Solution {
    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * Time Complexity: O(n + m)
     * - where n = number of nodes in list1, m = number of nodes in list2
     * - each node is visited exactly once.
     *
     * Space Complexity: O(1)
     * - constant extra space is used (no new nodes created, only pointers adjusted)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        // Traverse both lists and link the smaller node each time
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // move the current pointer forward
        }

        // One of the lists may still have nodes left; link it directly
        current.next = (list1 != null) ? list1 : list2;

        // Return the head of the merged list (skip dummy node)
        return dummyHead.next;
    }
}

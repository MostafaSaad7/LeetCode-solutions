class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1, head);
        ListNode slowPointer = dummyHead;
        ListNode fastPointer = head;

        while (n-- != 0) {

            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;
        return dummyHead.next;
    }
}
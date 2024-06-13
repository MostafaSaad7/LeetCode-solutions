class Solution {
    public void reorderList(ListNode head) {

        ListNode secondHalfStart = splitListIntoToHalfs(head);
        ListNode head2 = reverseLinkedList(secondHalfStart);
        merge(head, head2);


    }


    private ListNode splitListIntoToHalfs(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode
                secondHalfHead = slow.next;
        slow.next = null;
        return secondHalfHead;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

        return head1;
    }


}
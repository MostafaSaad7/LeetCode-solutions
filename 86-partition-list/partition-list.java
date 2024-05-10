
class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode beforeList = new ListNode(-1);
        ListNode afterList = new ListNode(-1);
        ListNode beforeStart = beforeList;
        ListNode afterStart = afterList;

        while (head != null) {
            if (head.val < x) {
                beforeList.next = head;
                beforeList = beforeList.next;
            } else {
                afterList.next = head;
                afterList = afterList.next;
            }
            head = head.next;
        }
        beforeList.next = afterStart.next;
        afterList.next = null;  // tail pointer to null
        return beforeStart.next;
    }
}
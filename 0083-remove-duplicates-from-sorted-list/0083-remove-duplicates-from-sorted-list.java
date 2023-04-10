/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        ListNode iterator = head.next;
        while(iterator != null){
            if(current.val == iterator.val){
                current.next = iterator.next;
                iterator = iterator.next;
            }else{
                current = iterator;
                iterator = iterator.next;
            }
        }
        return head;

  


}
}
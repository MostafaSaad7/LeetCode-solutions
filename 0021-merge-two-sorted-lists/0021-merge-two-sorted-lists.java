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

    /**
     * Merges two sorted linked lists into one sorted list using recursion.
     *
     * Time Complexity: O(n + m)
     * - We visit each node of both list1 and list2 exactly once.
     * - n is the length of list1, m is the length of list2.
     *
     * Space Complexity: O(n + m)
     * - Due to recursive calls, the call stack will grow up to n + m in the worst case
     *   (if all nodes are interleaved).
     * - No additional data structures are used, but recursion uses implicit stack space.
     *
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base Case 1: If list1 is empty, return list2
        if (list1 == null)
            return list2;

        // Base Case 2: If list2 is empty, return list1
        if (list2 == null)
            return list1;

        // Recursive Case:
        if (list1.val <= list2.val) {
            // Use list1 node, and merge the rest recursively
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // Use list2 node, and merge the rest recursively
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

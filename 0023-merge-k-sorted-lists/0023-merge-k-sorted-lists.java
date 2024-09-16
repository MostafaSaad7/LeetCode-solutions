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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a dummy node to simplify the process of constructing the result list
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        // Initialize a priority queue that sorts ListNode by their value
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // Process the nodes in the priority queue
        while (!queue.isEmpty()) {
            ListNode smallestNode = queue.poll();
            current.next = smallestNode;
            current = current.next;

            // If the extracted node has a next node, add it to the queue
            if (smallestNode.next != null) {
                queue.add(smallestNode.next);
            }
        }

        // Return the merged list starting from the next node of the dummy
        return dummy.next;
    }
}
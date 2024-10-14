class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.val, r2.val));

        for (ListNode root : lists) {

            while (root != null) {
                priorityQueue.add(root);
                root = root.next;
            }
        }


        ListNode newRoot = new ListNode();
        ListNode curr = newRoot;
        while (!priorityQueue.isEmpty()) {
            curr.next = priorityQueue.poll();
            curr = curr.next;
            curr.next = null;
        }


        return newRoot.next;

    }
}
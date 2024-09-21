class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNodeToNewNode = new HashMap<>();
        oldNodeToNewNode.put(null, null);
        Node currentOriginalNode = head;

        // First pass: Create new nodes and store them in the map
        while (currentOriginalNode != null) {
            oldNodeToNewNode.put(currentOriginalNode, new Node(currentOriginalNode.val));
            currentOriginalNode = currentOriginalNode.next;
        }
        
        // Second pass: Assign next and random pointers
        currentOriginalNode = head;
        while (currentOriginalNode != null) {
            Node temp = oldNodeToNewNode.get(currentOriginalNode);
            temp.next = oldNodeToNewNode.get(currentOriginalNode.next);
            temp.random = oldNodeToNewNode.get(currentOriginalNode.random);
            currentOriginalNode = currentOriginalNode.next;
        }

        // Return the head of the new list
        return oldNodeToNewNode.get(head);
    }
}

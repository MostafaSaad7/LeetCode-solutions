


class Solution {
    Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;

        if (visited.containsKey(node.val))
            return visited.get(node.val);

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        
        for (Node neighbour : node.neighbors) {

            newNode.neighbors.add(cloneGraph(neighbour));
        }

        return newNode;
    }
}
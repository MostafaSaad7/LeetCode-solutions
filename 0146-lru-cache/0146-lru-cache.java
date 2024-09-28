import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class Node {

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    int capacity;
    Map<Integer, Node> cache;
    Node left; // points to LRU node
    Node right; // points to MRU node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }


    }


    // remove node form the list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }


    // insert node to the MRU ---> the right
    private void insert(Node node) {

        Node prev = right.prev;

        node.prev = prev;
        node.next = right;

        prev.next = node;
        right.prev = node;

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
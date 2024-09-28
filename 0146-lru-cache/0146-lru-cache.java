import java.util.*;

class LRUCache {

    private final Map<Integer, Integer> cache;
    private final List<Integer> timeSeries;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.timeSeries = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        // Mark the key as recently used
        moveKeyToRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update value and mark key as recently used
            cache.put(key, value);
            moveKeyToRecent(key);
        } else {
            // Add a new key-value pair and handle LRU eviction if necessary
            if (cache.size() == capacity) {
                evictLeastRecentlyUsed();
            }
            addNewEntry(key, value);
        }
    }

    // Moves the accessed key to the end of the timeSeries list
    private void moveKeyToRecent(int key) {
        timeSeries.remove((Integer) key);  // O(n) operation
        timeSeries.add(key);               // O(1) operation
    }

    // Evicts the least recently used entry from the cache and timeSeries
    private void evictLeastRecentlyUsed() {
        Integer lruKey = timeSeries.remove(0);  // O(1) operation
        cache.remove(lruKey);                   // O(1) operation
    }

    // Adds a new entry to the cache and marks it as recently used
    private void addNewEntry(int key, int value) {
        cache.put(key, value);  // O(1) operation
        timeSeries.add(key);    // O(1) operation
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

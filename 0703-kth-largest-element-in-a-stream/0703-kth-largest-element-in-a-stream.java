import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> priorityQueue;
    PriorityQueue<Integer> priorityQueueMax;
    int times = 0;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueMax = new PriorityQueue<>();
        times = k;
        for (int num : nums) {
            priorityQueue.add(num);
        }
        for (int i = 0; i < times && !priorityQueue.isEmpty(); i++) {
            priorityQueueMax.add(priorityQueue.remove());
        }
    }

    public int add(int val) {
        if (priorityQueueMax.isEmpty()) {
            priorityQueueMax.add(val);
        } else if (val > priorityQueueMax.peek() && priorityQueueMax.size() == times) {
            priorityQueue.add(priorityQueueMax.remove());
            priorityQueueMax.add(val);
        } else if (priorityQueueMax.size() < times) {
            priorityQueueMax.add(val);
        } else {
            priorityQueue.add(val);
        }
        return priorityQueueMax.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
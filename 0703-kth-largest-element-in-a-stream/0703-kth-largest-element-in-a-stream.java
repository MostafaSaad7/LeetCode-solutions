import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> priorityQueueMax;
    int times = 0;

    public KthLargest(int k, int[] nums) {
        priorityQueueMax = new PriorityQueue<>();
        times = k;
        for (int i = 0; i < nums.length; i++) {
            priorityQueueMax.add(nums[i]);
            if (priorityQueueMax.size() > times)
                priorityQueueMax.remove();

        }
    }

    public int add(int val) {
        if (priorityQueueMax.size() < times)
            priorityQueueMax.add(val);
        else if (priorityQueueMax.peek() < val) {
            priorityQueueMax.remove();
            priorityQueueMax.add(val);
        }

        return priorityQueueMax.peek();
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
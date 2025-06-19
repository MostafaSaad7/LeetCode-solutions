import java.util.PriorityQueue;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Min-heap to always access the smallest element
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all numbers to the priority queue
        for (int num : nums) {
            pq.offer(num);
        }

        // Flip the smallest element k times
        while (k-- > 0) {
            int smallest = pq.poll();
            pq.offer(-smallest);  // Flip it and add it back
        }

        // Compute the total sum
        int total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        return total;
    }
}

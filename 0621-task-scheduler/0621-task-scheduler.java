import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] freq = new int[26];
        for (char character : tasks) {
            freq[character - 'A']++;
        }
        for (var count : freq) {
            if (count != 0)
                priorityQueue.offer(count);
        }
        Queue<Integer[]> queue = new LinkedList<>();

        while (!priorityQueue.isEmpty() || !queue.isEmpty()) {
            time++;
            int currentTask = 0;
            if (!priorityQueue.isEmpty())
                currentTask = priorityQueue.poll();
            currentTask--;

            if (currentTask > 0)
                queue.add(new Integer[]{currentTask, time + n});

            if (!queue.isEmpty() && queue.peek()[1] == time)
                priorityQueue.offer(queue.poll()[0]);
        }
        return time;
    }
}
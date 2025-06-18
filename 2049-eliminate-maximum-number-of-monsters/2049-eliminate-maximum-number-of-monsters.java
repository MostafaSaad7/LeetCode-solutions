import java.util.PriorityQueue;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> arrivalTimes = new PriorityQueue<>();

        // Calculate arrival time for each monster and add to priority queue
        for (int i = 0; i < dist.length; i++) {
            arrivalTimes.add(dist[i] / (double) speed[i]);
        }

        int time = 0;

        while (!arrivalTimes.isEmpty()) {
            double monsterTime = arrivalTimes.poll();

            // If this monster reaches before or at current time, we lose
            if (monsterTime <= time) {
                return time;
            }

            time++; // Shoot one monster per minute
        }

        return time;
    }
}

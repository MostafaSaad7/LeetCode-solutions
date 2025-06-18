import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] time = new double[n];

        // Calculate time to reach for each monster
        for (int i = 0; i < n; i++) {
            time[i] = (double) dist[i] / speed[i];
        }

        // Sort times in ascending order
        Arrays.sort(time);

        // Eliminate monsters one per minute
        for (int t = 0; t < n; t++) {
            if (time[t] <= t) {
                return t;
            }
        }

        return n; // All monsters eliminated
    }
}

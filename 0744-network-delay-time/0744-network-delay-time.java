import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Initialize the distance array with a large value (1000000)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000);
        
        // Step 2: Set the distance to the source node (k) as 0
        dist[k] = 0;

        // Step 3: Perform Bellman-Ford relaxation for (n-1) iterations
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];
                if ( dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 4: Find the maximum delay time (ignore index 0)
        int maxTime = Arrays.stream(dist, 1, n + 1).max().getAsInt();
        
        // Step 5: If any node is unreachable, return -1
        return maxTime >= 1000000 ? -1 : maxTime;
    }
}

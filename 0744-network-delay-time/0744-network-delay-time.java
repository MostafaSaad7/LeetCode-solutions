import java.util.Arrays;

class Solution {
    private static final int OO = (int) 1e6;  // Infinite value

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adjMax = new int[n][n];

        for (int[] row : adjMax)
            Arrays.fill(row, OO);

        for (int[] edge : times) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int cost = edge[2];
            adjMax[from][to] = cost;
        }

        int[] shortestPaths = dijkstra(adjMax, k - 1);

        int maxTime = Arrays.stream(shortestPaths).max().orElse(OO);
        return (maxTime >= OO) ? -1 : maxTime;
    }

    private int[] dijkstra(int[][] adjMax, int src) {
        int n = adjMax.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, OO);
        dist[src] = 0;

        while (true) {
            int minIndx = -1;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minValue) {
                    minValue = dist[i];
                    minIndx = i;
                }
            }


            if (minIndx == -1)
                break;

            for (int i = 0; i < n; ++i) {

                if (dist[i] > dist[minIndx] + adjMax[minIndx][i]) {
                    dist[i] = dist[minIndx] + adjMax[minIndx][i];
                }

            }

            visited[minIndx] = true;  // Mark as visited (delete)

        }


        return dist;

    }
}
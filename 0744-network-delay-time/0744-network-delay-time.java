import java.util.*;

class Solution {
    private static final int OO = (int) 1e6;  // Infinite value

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int cost = time[2];
            adjList.get(from).add(new Edge(to, cost));
        }

        int[] shortestPaths = dijkstra(adjList, n, k - 1);

        int maxTime = Arrays.stream(shortestPaths).max().orElse(OO);
        return (maxTime >= OO) ? -1 : maxTime;
    }

    private int[] dijkstra(List<List<Edge>> adjList, int n, int src) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, OO);
        dist[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            int minIdx = minEdge.to;

            if (visited[minIdx]) {
                continue;
            }

            for (Edge edge : adjList.get(minIdx)) {
                int to = edge.to;
                int weight = edge.weight;

                if (dist[to] > dist[minIdx] + weight) {
                    dist[to] = dist[minIdx] + weight;
                    pq.add(new Edge(to, dist[to]));
                }
            }

            visited[minIdx] = true;  // Mark as visited (delete)
        }
        return dist;
    }

    class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight; // Min-heap by weight
        }
    }
}

import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007;
    private static final long OO = (1_000_000_010L) * 200;

    public int countPaths(int n, int[][] roads) {

        List<List<Edge>> adjList = buildTheGraph(n, roads);
        return dijkstra(adjList, n, 0, n - 1);
    }

    private List<List<Edge>> buildTheGraph(int n, int[][] roads) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int from = road[0], to = road[1], cost = road[2];
            // Undirected edge = 2 directed edges
            adjList.get(from).add(new Edge(to, cost));
            adjList.get(to).add(new Edge(from, cost));
        }

        return adjList;
    }


    private int dijkstra(List<List<Edge>> adjList, int n, int src, int target) {

        long[] dist = new long[n];
        Arrays.fill(dist, OO);
        dist[src] = 0;


        long[] pathsCnt = new long[n];
        pathsCnt[src] = 1;


        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(src, 0));
        while (!queue.isEmpty()) {

            Edge minEdge = queue.poll();
            int mnIdx = minEdge.to;

            if (minEdge.weight > dist[mnIdx]) {
                continue; // Cannot relax further
            }

            for (Edge edge : adjList.get(mnIdx)) {
                int to = edge.to;
                long weight = edge.weight;

                if (dist[to] > dist[mnIdx] + weight) {
                    // New cost found, update the shortest path
                    dist[to] = dist[mnIdx] + weight;
                    pathsCnt[to] = pathsCnt[mnIdx];
                    queue.add(new Edge(to, dist[to]));
                } else if (dist[to] == dist[mnIdx] + weight) {
                    pathsCnt[to] = (pathsCnt[to] + pathsCnt[mnIdx]) % MOD;

                }
            }

        }
        return (int) pathsCnt[target];
    }

}


class Edge implements Comparable<Edge> {

    int to;
    long weight;

    public Edge(int to, long weight) {

        this.to = to;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge other) {
        return Long.compare(this.weight, other.weight); // Min-heap based on weight
    }
}
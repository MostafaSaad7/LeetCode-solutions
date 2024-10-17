import javax.swing.plaf.basic.BasicProgressBarUI;
import java.util.*;

class Solution {

    private static final long MOD = 1_000_000_007;
    private static final long OO = 2_000_000_010L;
    private long[] memory;


    static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        // PriorityQueue will sort edges based on weight
        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.weight, other.weight);
        }

    }

    public int countRestrictedPaths(int n, int[][] roads) {
        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph with undirected edges
        for (int[] road : roads) {
            int from = road[0] - 1;
            int to = road[1] - 1;
            int cost = road[2];

            adjList.get(from).add(new Edge(to, cost));
            adjList.get(to).add(new Edge(from, cost));
        }

        // Find shortest paths from the last node (n-1) to all other nodes
        List<Long> dist = dijkstra(adjList, n, n - 1);

        memory = new long[n];
        Arrays.fill(memory, -1);

        return (int) countPaths(0, n - 1, adjList, dist);

    }

    private long countPaths(int src, int target, List<List<Edge>> adjList, List<Long> dist) {
        if (src == target) {
            return 1;
        }

        if (memory[src] != -1) {
            return memory[src];
        }

        long PathsCount = 0;
        for (Edge edge : adjList.get(src)) {
            if (dist.get(src) > dist.get(edge.to)) {
                PathsCount += countPaths(edge.to, target, adjList, dist);
                PathsCount %= MOD;
            }

        }
        memory[src] = PathsCount;
        return PathsCount;
    }

    private List<Long> dijkstra(List<List<Edge>> adjList, int n, int src) {

        List<Long> dist = new ArrayList<>(Collections.nCopies(n, OO));
        boolean[] visited = new boolean[n];
        dist.set(src, 0L);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(src, 0));

        while (!priorityQueue.isEmpty()) {
            Edge minEdge = priorityQueue.poll();

            int currentNode = minEdge.to;
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;

            for (Edge edge : adjList.get(currentNode)) {
                int nextNode = edge.to;
                long newDist = dist.get(currentNode) + edge.weight;

                if (newDist < dist.get(nextNode)) {
                    dist.set(nextNode, newDist);
                    priorityQueue.add(new Edge(nextNode, newDist));
                }
            }
        }
        return dist;
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Initialize all distances to -1
        }
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Build the graph with red and blue edges
        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new Edge(edge[1], 0)); // 0 for red
        }
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new Edge(edge[1], 1)); // 1 for blue
        }
        // BFS initialization
        boolean[][] visited = new boolean[n][2]; // visited[node][color]
        visited[0][0] = true; // Start with red edge
        visited[0][1] = true; // Start with blue edge
        result[0] = 0; // Distance to the starting node is 0
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[]{0, 0}); // Start with node 0 and red edge
        queue.add(new int[]{0, 1}); // Start with node 0 and blue edge
        int distance = 1; // Start BFS with distance 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.remove(0);
                int node = current[0];
                int color = current[1];

                for (Edge edge : graph.get(node)) {
                    if (edge.color != color && !visited[edge.node][edge.color]) {
                        visited[edge.node][edge.color] = true;
                        if (result[edge.node] == -1) {
                            result[edge.node] = distance; // Update distance if not set
                        }
                        queue.add(new int[]{edge.node, edge.color});
                    }
                }
            }
            distance++; // Increment distance after processing all nodes at the current level
        }

        return result;

    }

    class Edge {
        int node;
        int color; // 0 for red, 1 for blue

        Edge(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}
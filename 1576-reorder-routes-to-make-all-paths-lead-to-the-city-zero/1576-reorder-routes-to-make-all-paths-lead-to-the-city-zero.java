import java.util.*;

class Solution {
    private int count = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();     // undirected adjacency
        Set<String> directedEdges = new HashSet<>();          // store original directions

        for (int[] edge : connections) {
            int from = edge[0], to = edge[1];

            // build undirected adjacency
            adj.computeIfAbsent(from, k -> new HashSet<>()).add(to);
            adj.computeIfAbsent(to, k -> new HashSet<>()).add(from);

            // record the original direction
            directedEdges.add(from + "," + to);
        }

        boolean[] visited = new boolean[n];
        dfs(0, adj, directedEdges, visited);

        return count;
    }

    private void dfs(int node, Map<Integer, Set<Integer>> adj, Set<String> directedEdges, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.getOrDefault(node, Collections.emptySet())) {
            if (!visited[neighbor]) {
                // if the original edge was node -> neighbor, it needs reversing
                if (directedEdges.contains(node + "," + neighbor)) {
                    count++;
                }
                dfs(neighbor, adj, directedEdges, visited);
            }
        }
    }
}

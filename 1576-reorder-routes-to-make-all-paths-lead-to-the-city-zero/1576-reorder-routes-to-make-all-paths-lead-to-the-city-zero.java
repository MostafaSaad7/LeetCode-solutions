import java.util.*;

class Solution {
    private int count = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : connections) {
            int from = edge[0], to = edge[1];
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1}); // original direction
            adj.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0}); // reverse direction
        }

        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
        return count;
    }

    private void dfs(int node, Map<Integer, List<int[]>> adj, boolean[] visited) {
        visited[node] = true;

        for (int[] edge : adj.getOrDefault(node, Collections.emptyList())) {
            int neighbor = edge[0];
            int direction = edge[1];
            if (!visited[neighbor]) {
                if (direction == 1) {
                    count++; // needs to be reversed
                }
                dfs(neighbor, adj, visited);
            }
        }
    }
}

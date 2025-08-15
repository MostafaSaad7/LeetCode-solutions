class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int BLUE = -1;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == UNCOLORED) {
                if (!dfs(i, RED, colors, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] colors, int[][] graph) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false; // same color conflict
            }
            if (colors[neighbor] == UNCOLORED && !dfs(neighbor, -color, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}

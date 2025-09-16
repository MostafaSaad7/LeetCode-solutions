import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int lenOfColors = colors.length();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        int[][] dp = new int[lenOfColors][26];
        boolean[] visited = new boolean[lenOfColors];
        boolean[] inStack = new boolean[lenOfColors];
        int maxColorValue = 0;

        for (int i = 0; i < lenOfColors; i++) {
            if (!visited[i]) {
                int result = dfs(i, colors, graph, dp, visited, inStack);
                if (result == -1) {
                    return -1; // Cycle detected
                }
            }
            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, dp[i][c]);
            }
        }
        return maxColorValue;
    }

    int dfs(int node, String colors, Map<Integer, List<Integer>> graph, int[][] dp, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) {
            return -1; // Cycle detected
        }
        if (visited[node]) {
            return dp[node][colors.charAt(node) - 'a'];
        }
        visited[node] = true;
        inStack[node] = true;
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfs(neighbor, colors, graph, dp, visited, inStack) == -1) {
                return -1; // Cycle detected in recursion
            }
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
            }
        }
        dp[node][colors.charAt(node) - 'a']++;
        inStack[node] = false;
        return dp[node][colors.charAt(node) - 'a'];
    }

}
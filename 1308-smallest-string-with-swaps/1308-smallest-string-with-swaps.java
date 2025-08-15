import java.util.*;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = s.length();

        // Build adjacency list
        for (List<Integer> pair : pairs) {
            graph.computeIfAbsent(pair.get(0), k -> new ArrayList<>()).add(pair.get(1));
            graph.computeIfAbsent(pair.get(1), k -> new ArrayList<>()).add(pair.get(0));
        }

        boolean[] visited = new boolean[n];
        char[] result = s.toCharArray();

        // DFS each connected component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> indices = new ArrayList<>();
                dfs(graph, i, visited, indices);

                // Sort indices
                Collections.sort(indices);

                // Extract & sort characters
                List<Character> chars = new ArrayList<>();
                for (int idx : indices) {
                    chars.add(s.charAt(idx));
                }
                Collections.sort(chars);

                // Place smallest chars in smallest indices
                for (int k = 0; k < indices.size(); k++) {
                    result[indices.get(k)] = chars.get(k);
                }
            }
        }

        return new String(result);
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited, List<Integer> indices) {
        visited[node] = true;
        indices.add(node);
        if (!graph.containsKey(node)) return;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, indices);
            }
        }
    }
}

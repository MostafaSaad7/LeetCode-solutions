import java.util.*;

class Solution {
    HashSet<Integer> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> graph = buildGraph(adjacentPairs);
        // Find the starting point (a node with only one neighbor)
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        dfs(graph, start);

        // Convert List<Integer> to int[]
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private void dfs(HashMap<Integer, List<Integer>> graph, int node) {
        if (visited.contains(node)) return;
        visited.add(node);
        result.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            dfs(graph, neighbor);
        }
    }

    HashMap<Integer, List<Integer>> buildGraph(int[][] adjPairs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : adjPairs) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return graph;
    }
}

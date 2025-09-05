import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n==1)
            return List.of(0);
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDeg = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        
        buildUndirectedGraph(edges, graph);
        buildInDegArray(n, graph, inDeg);
        startWithLeafNodes(n, inDeg, queue);
        res = bfs(graph, inDeg, queue, res);

        return res;
    }

    private static List<Integer> bfs(HashMap<Integer, List<Integer>> graph, int[] inDeg, Queue<Integer> queue, List<Integer> res) {
        for (int sz = queue.size(); !queue.isEmpty(); sz = queue.size()) {
            res = new ArrayList<>();
            while (sz-- != 0) {
                int node = queue.poll();
                res.add(node);
                for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                    if (--inDeg[neighbour] == 1) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return res;
    }

    private static void startWithLeafNodes(int n, int[] inDeg, Queue<Integer> queue) {
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1) {
                queue.add(i);
            }

        }
    }

    private static void buildInDegArray(int n, HashMap<Integer, List<Integer>> graph, int[] inDeg) {
        for (int i = 0; i < n; i++) {
            for (int neighbour : graph.getOrDefault(i, new ArrayList<>())) {
                inDeg[neighbour]++;
            }
        }
    }

    private static void buildUndirectedGraph(int[][] edges, HashMap<Integer, List<Integer>> graph) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }
}
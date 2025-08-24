import java.util.*;

class Solution {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, List<Edge>> graph = new HashMap<>();

        buildGraph(redEdges, 'r', graph);
        buildGraph(blueEdges, 'b', graph);

        bfs(graph, res);

        return res;
    }

    private static void buildGraph(int[][] edges, char color, Map<Integer, List<Edge>> graph) {
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(new Edge(end, color));
        }
    }

    private static void bfs(Map<Integer, List<Edge>> graph, int[] res) {
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(0, 'x'));
        Set<Edge> visited = new HashSet<>();
        visited.add(new Edge(0, 'x'));
        res[0] = 0;
        for (int level=0,sz= queue.size(); !queue.isEmpty();level++,sz= queue.size()) {
            while (sz-->0) {
                    Edge edge = queue.poll();
                    char currentColor = edge.color;
                    for (Edge e : graph.getOrDefault(edge.to, new ArrayList<>())) {
                        if (currentColor == e.color || visited.contains(e)) continue;
                        queue.add(e);
                        visited.add(e);
                        if (res[e.to] == -1) res[e.to] = level + 1;

                    

                }
            }
        }
    }

    static class Edge {
        int to;
        char color;

        public Edge(int to, char color) {
            this.to = to;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{});
    }
}
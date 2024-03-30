import java.util.*;

class Solution {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (var e : redEdges) {
            if (!graph.containsKey(e[0])) {
                List<Edge> temp = new ArrayList();
                temp.add(new Edge(e[1], 'r'));
                graph.put(e[0], temp);

            } else {
                List<Edge> temp = graph.get(e[0]);
                temp.add(new Edge(e[1], 'r'));
                graph.put(e[0], temp);
            }
        }
        for (var e : blueEdges) {
            if (!graph.containsKey(e[0])) {
                List<Edge> temp = new ArrayList();
                temp.add(new Edge(e[1], 'b'));
                graph.put(e[0], temp);

            } else {
                List<Edge> temp = graph.get(e[0]);
                temp.add(new Edge(e[1], 'b'));
                graph.put(e[0], temp);
            }
        }

        char currentColor = 'x';
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(0, 'x'));
        HashSet<Edge> vis = new HashSet<>();
        vis.add(new Edge(0, 'x'));
        res[0] = 0;
        for (int level = 0, sz = queue.size(); !queue.isEmpty(); level++, sz = queue.size()) {
            while (sz-- > 0) {
                Edge edge = queue.poll();
                currentColor = edge.color;
                for (Edge e : graph.getOrDefault(edge.to, new ArrayList<>())) {
                    if (currentColor == e.color || vis.contains(e)) {
                        continue;
                    }
                    queue.add(e);
                    vis.add(e);
                    if (res[e.to] == -1)
                        res[e.to] = level + 1;
                }

            }

        }

        return res;
    }


    static class Edge {
        int to;
        char color;

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public char getColor() {
            return color;
        }

        public void setColor(char color) {
            this.color = color;
        }

        public Edge(int to, char color) {
            this.to = to;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{});
    }
}
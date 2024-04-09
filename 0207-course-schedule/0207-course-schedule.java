import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(prerequisites);
        return topologicalSort(numCourses);
    }

    private boolean topologicalSort(int numCourses) {
        int[] inDeg = new int[numCourses];
        for (List<Integer> edges : graph.values()) {
            for (int node : edges) {
                ++inDeg[node];
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0)
                queue.add(i);
        }

        ArrayList<Integer> resultOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            resultOrder.add(currentNode);
            for (int neighbour :  graph.getOrDefault(currentNode, Collections.emptyList())) {
                if (--inDeg[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return resultOrder.size() == numCourses;
    }


    void buildGraph(int[][] prerequisites) {
        for (int[] edge : prerequisites) {
            addDirectedEdge(edge);
        }
    }

    void addDirectedEdge(int[] edge) {
        graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
    }
}
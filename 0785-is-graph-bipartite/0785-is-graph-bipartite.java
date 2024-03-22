import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {


    /*
     * Two colors problem
     *
     * */
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i]=0;
        }
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbour : graph[node]) {
                    if (visited[neighbour] == visited[node]) {
                        return false;
                    } else if (visited[neighbour] == 0) {
                        visited[neighbour] = visited[node] * -1;
                        queue.add(neighbour);
                    }
                }


            }
        }

        return true;
    }
}
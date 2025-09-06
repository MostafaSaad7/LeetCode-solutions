import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int sz = time.length;
        int[] indegree = new int[sz];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < sz; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] finishTime = new int[sz];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            finishTime[u] += time[u];
            if (graph.containsKey(u)) {
                for (int v : graph.get(u)) {
                    finishTime[v] = Math.max(finishTime[v], finishTime[u]);
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }

        int ans = 0;
        for (int t : finishTime) {
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
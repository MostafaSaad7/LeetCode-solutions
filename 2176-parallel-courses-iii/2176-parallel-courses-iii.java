import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // Build graph: course -> list of dependents
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] r : relations) {
            int u = r[0] - 1; // prerequisite
            int v = r[1] - 1; // dependent
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        int[] memo = new int[n]; // longest path from each course
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfsForward(i, graph, time, memo));
        }
        return ans;
    }

    private int dfsForward(int course, Map<Integer, List<Integer>> graph, int[] time, int[] memo) {
        if (memo[course] > 0) return memo[course];

        int res = time[course];
        if (graph.containsKey(course)) {
            for (int nei : graph.get(course)) {
                res = Math.max(res, time[course] + dfsForward(nei, graph, time, memo));
            }
        }

        memo[course] = res;
        return res;
    }
}

import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // Build graph: course -> list of prerequisites
        Map<Integer, List<Integer>> prereqGraph = new HashMap<>();
        for (int[] r : relations) {
            int u = r[0] - 1; // prerequisite
            int v = r[1] - 1; // course
            prereqGraph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] memo = new int[n]; // finish times
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfsPrereq(i, prereqGraph, time, memo));
        }
        return ans;
    }

    private int dfsPrereq(int course, Map<Integer, List<Integer>> graph, int[] time, int[] memo) {
        if (memo[course] > 0) return memo[course];

        int maxPre = 0;
        if (graph.containsKey(course)) {
            for (int pre : graph.get(course)) {
                maxPre = Math.max(maxPre, dfsPrereq(pre, graph, time, memo));
            }
        }

        memo[course] = maxPre + time[course];
        return memo[course];
    }
}

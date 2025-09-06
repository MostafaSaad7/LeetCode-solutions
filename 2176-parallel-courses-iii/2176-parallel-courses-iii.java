import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] r : relations) {
            int u = r[0], v = r[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Map<Integer, Integer> memo = new HashMap<>();

        // DFS function
        class DFS {
            int run(int course) {
                if (memo.containsKey(course)) return memo.get(course);

                int res = time[course - 1]; // base: if no dependents
                if (graph.containsKey(course)) {
                    for (int nei : graph.get(course)) {
                        res = Math.max(res, time[course - 1] + run(nei));
                    }
                }

                memo.put(course, res);
                return res;
            }
        }

        DFS dfs = new DFS();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dfs.run(i));
        }

        return ans;
    }
}

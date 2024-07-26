import java.util.HashMap;
import java.util.Map;

class Solution {
    private final int MOD = 1_000_000_007;
    private Map<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int n, int k, int target) {
        return dfs(n, k, target);
    }

    private int dfs(int n, int k, int target) {
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        String key = n + "," + target;
        if (memo.containsKey(key)) return memo.get(key);

        int ways = 0;
        for (int face = 1; face <= k; face++) {
            ways = (ways + dfs(n - 1, k, target - face)) % MOD;
        }

        memo.put(key, ways);
        return ways;
    }
}

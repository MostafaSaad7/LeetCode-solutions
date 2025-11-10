import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;
    int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (var arr : dp) Arrays.fill(arr, -1);
        return solve(n, k, target);
    }

    int solve(int n, int faces, int target) {
        if (target < 0) return 0;
        if (n == 0) return target == 0 ? 1 : 0;

        if (dp[n][target] != -1) return dp[n][target];

        long ways = 0;
        for (int face = 1; face <= faces; face++) {
            ways += solve(n - 1, faces, target - face);
            ways %= MOD;
        }

        return dp[n][target] = (int) ways;
    }
}

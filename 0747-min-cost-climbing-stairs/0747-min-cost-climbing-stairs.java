import java.util.Arrays;

class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost), solve(1, cost));
    }

    public int solve(int idx, int[] cost) {
        if (idx >= cost.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int choice1 = cost[idx] + solve(idx + 1, cost);
        int choice2 = cost[idx] + solve(idx + 2, cost);

        dp[idx] = Math.min(choice1, choice2);
        return dp[idx];
    }
}
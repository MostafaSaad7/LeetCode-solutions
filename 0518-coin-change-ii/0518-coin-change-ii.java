import java.util.Arrays;

class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for (var arr : dp) {
            Arrays.fill(arr, -1);

        }
        return solve(0, coins, amount);

    }


    int solve(int idx, int[] coins, int amount) {
        if (amount == 0)
            return 1;
        if (amount < 0 || idx >= coins.length)
            return 0;

        if (dp[idx][amount] != -1)
            return dp[idx][amount];


        int c1 = solve(idx, coins, amount - coins[idx]);
        int c2 = solve(idx + 1, coins, amount);

        dp[idx][amount] = c1 + c2;

        return dp[idx][amount];
    }
}
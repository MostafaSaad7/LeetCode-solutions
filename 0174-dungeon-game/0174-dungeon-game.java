import java.util.Arrays;

class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(dungeon, 0, 0, dp);

    }

    int solve(int[][] dungeon, int i, int j, int[][] dp) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = solve(dungeon, i + 1, j, dp);
        int right = solve(dungeon, i, j + 1, dp);
        int minHealthOnExit = Math.min(down, right);
        dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
        return dp[i][j];

    }
}
class Solution {
    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        int maxCount = 0;
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {

                if (dp[i][j - 1] > 0 && grid[i][j] > grid[i][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);

                }

                if (i > 0 && dp[i - 1][j - 1] > 0 && grid[i][j] > grid[i - 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);

                }

                if (i < M - 1 && dp[i + 1][j - 1] > 0 && grid[i][j] > grid[i + 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }

                maxCount = Math.max(maxCount, dp[i][j] - 1);
            }
        }

        return maxCount;
    }
}
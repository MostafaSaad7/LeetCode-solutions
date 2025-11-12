class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] dp;
    final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        
        // Initialize with -1 to mark uncomputed states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int remainingMoves, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        if (remainingMoves == 0) {
            return 0;
        }
        
        // Check if already computed
        if (dp[row][col][remainingMoves] != -1) {
            return dp[row][col][remainingMoves];
        }

        int totalPaths = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            totalPaths = (totalPaths + dfs(m, n, remainingMoves - 1, newRow, newCol)) % MOD;
        }

        dp[row][col][remainingMoves] = totalPaths;
        return totalPaths;
    }
}
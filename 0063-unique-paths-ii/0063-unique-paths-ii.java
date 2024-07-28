import java.util.Arrays;

class Solution {
    int gridRows;
    int gridCols;
    int[][] obstacleGridRef;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        Integer[] dp = new Integer[cols];
        Arrays.fill(dp, 0);
        dp[cols - 1] = 1;
        for (int row = rows - 1; row > -1; row--) {
            for (int col = cols - 1; col > -1; col--) {
                if (obstacleGrid[row][col] == 1)
                    dp[col] = 0;
                else if (col + 1 < cols) {
                    dp[col] = dp[col] + dp[col + 1]; // note that dp[col] on the right side calculated before from previous calculations
                }

            }

        }

        return dp[0];
    }

    int uniquePaths(int row, int column, Integer[][] dp) {
        if (row == gridRows || column == gridCols || obstacleGridRef[row][column] == 1)
            return 0;
        if (dp[row][column] != null)
            return dp[row][column];

        int numberOfWays = uniquePaths(row + 1, column, dp) + uniquePaths(row, column + 1, dp);
        dp[row][column] = numberOfWays;
        return dp[row][column];
    }
}
class Solution {
    int gridRows;
    int gridCols;
    int[][] obstacleGridRef;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        gridRows = obstacleGrid.length;
        gridCols = obstacleGrid[0].length;
        obstacleGridRef = obstacleGrid;
        return uniquePaths(0, 0, new Integer[gridRows][gridCols]);
    }

    int uniquePaths(int row, int column, Integer[][] dp) {
        if (row == gridRows || column == gridCols || obstacleGridRef[row][column] == 1)
            return 0;
        if (row == gridRows - 1 && column == gridCols - 1)
            return 1;

        if (dp[row][column] != null)
            return dp[row][column];
        
        int numberOfWays = uniquePaths(row + 1, column, dp) + uniquePaths(row, column + 1, dp);
        dp[row][column] = numberOfWays;
        return dp[row][column];
    }
}
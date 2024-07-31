class Solution {
    int rows;
    int cols;
    int[][] dungeonRef;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1; // If the dungeon is empty, the knight needs at least 1 health to be alive.
        }
        
        rows = dungeon.length;
        cols = dungeon[0].length;
        Integer[][] dp = new Integer[rows][cols];
        dungeonRef = dungeon;
        return dfs(0, 0, dp);
    }

    private int dfs(int row, int col, Integer[][] dp) {
        if (row >= rows || col >= cols) {
            return Integer.MAX_VALUE;
        }

        // Base case: the last cell (bottom-right corner)
        if (row == rows - 1 && col == cols - 1) {
            if (dungeonRef[row][col] < 0) {
                return 1 - dungeonRef[row][col]; // Minimum health required if the last cell is negative
            }
            return 1; // If the last cell is positive, minimum health required is 1
        }

        // Use memoization to avoid recalculating
        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int minRequiredHealthToCoverCells = Math.min(dfs(row + 1, col, dp), dfs(row, col + 1, dp));
        if (minRequiredHealthToCoverCells <= dungeonRef[row][col]) {
            dp[row][col] = 1;
        } else {
            dp[row][col] = minRequiredHealthToCoverCells - dungeonRef[row][col];
        }

        return dp[row][col];
    }
}

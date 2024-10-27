class Solution {
    int maxCount = 0;

    public int countSquares(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, dp);
            }
        }
        return maxCount;
    }

    private int dfs(int[][] matrix, int row, int col, Integer[][] dp) {
        if (!valid(row, col, matrix) || matrix[row][col] == 0)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];

        int sideLen = 1 + Math.min(
                dfs(matrix, row + 1, col + 1, dp),
                Math.min(
                        dfs(matrix, row + 1, col, dp),
                        dfs(matrix, row, col + 1, dp)
                )
        );

        dp[row][col] = sideLen;
        maxCount += sideLen; 

        return sideLen;
    }

    private boolean valid(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxCount = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // Only update dp[i][j] if the original matrix cell is 1
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j]
                            )
                    );
                    maxCount += dp[i][j];
                }
            }
        }

        return maxCount;
    }
}

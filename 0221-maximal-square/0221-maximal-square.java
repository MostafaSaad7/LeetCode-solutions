class Solution {
    int[][] dp;

    public int maximalSquare(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, solve(i, j, matrix));
            }
        }

        return max * max;
    }

    private int solve(int i, int j, char[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] == '0') {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = solve(i, j + 1, matrix);
        int down = solve(i + 1, j, matrix);
        int diagonal = solve(i + 1, j + 1, matrix);
        dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
        return dp[i][j];
    }
}
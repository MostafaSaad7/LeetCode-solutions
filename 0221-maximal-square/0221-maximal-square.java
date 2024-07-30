class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;

        // DP array to store the side length of the largest square ending at (r, c)
        int[][] dp = new int[rows + 1][cols + 1];

        // Iterate through each cell in the matrix
        for (int r = 1; r <= rows; ++r) {
            for (int c = 1; c <= cols; ++c) {
                if (matrix[r - 1][c - 1] == '1') {
                    // DP transition: 1 + minimum of the three neighboring cells (up, left, and diagonal)
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                    // Update the maximum side length found
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }

        // Return the area of the largest square
        return maxSide * maxSide;
    }

    /*
     * Time Complexity: O(N * M)
     * - Each cell in the matrix is processed once, resulting in O(N * M) time complexity.
     *
     * Space Complexity: O(N * M)
     * - A DP array of size (N + 1) x (M + 1) is used, resulting in O(N * M) space complexity.
     */
}

class Solution {
    char[][] matrixRef;
    int rows, cols;

    public int maximalSquare(char[][] matrix) {
        matrixRef = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        Integer[][] cache = new Integer[rows][cols];

        int maxSide = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxSide = Math.max(maxSide, dfs(r, c, cache));
            }
        }

        return maxSide * maxSide;
    }

    private int dfs(int row, int col, Integer[][] cache) {
        if (row == rows || col == cols)
            return 0;
        if (matrixRef[row][col] == '0')
            return 0;
        if (cache[row][col] != null)
            return cache[row][col];

        int right = dfs(row, col + 1, cache);
        int down = dfs(row + 1, col, cache);
        int diagonal = dfs(row + 1, col + 1, cache);

        int sideLen = 1 + Math.min(right, Math.min(down, diagonal));
        cache[row][col] = sideLen;
        return sideLen;
    }

    /*
     * Time Complexity: O(N * M)
     * - Each cell is visited once, and results are memoized.
     * - There are N rows and M columns, so the total time complexity is O(N * M).
     *
     * Space Complexity: O(N * M)
     * - The cache array stores results for each cell, requiring O(N * M) space.
     * - The recursion stack can go as deep as O(N + M) in the worst case.
     */
}

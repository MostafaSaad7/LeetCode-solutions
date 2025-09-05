class Solution {
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m, n;
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];

        int best = 1; // path length at least 1 (the cell itself)
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(matrix, x, y));
            }
        }
        memo[i][j] = best;
        return best;
    }
}

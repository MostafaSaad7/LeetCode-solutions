class Solution {

    private final int MOD = 1_000_000_007;
    private int rows, cols;
    private Integer[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        cols = n;
        memo = new Integer[m][n][maxMove + 1];
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int row, int column, int moves) {
        if (moves < 0) return 0;
        if (row < 0 || row >= rows || column < 0 || column >= cols) return 1;
        
        if (memo[row][column][moves] != null) return memo[row][column][moves];

        int paths = 0;
        paths = (paths + dfs(row + 1, column, moves - 1)) % MOD;
        paths = (paths + dfs(row - 1, column, moves - 1)) % MOD;
        paths = (paths + dfs(row, column + 1, moves - 1)) % MOD;
        paths = (paths + dfs(row, column - 1, moves - 1)) % MOD;

        memo[row][column][moves] = paths;
        return paths;
    }
}

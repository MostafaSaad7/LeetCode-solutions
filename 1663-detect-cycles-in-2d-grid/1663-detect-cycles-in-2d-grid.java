class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] grid, int row, int col, int parentRow, int parentCol, char target) {
        if (visited[row][col]) {
            return true; // found a cycle
        }

        visited[row][col] = true;

        for (int[] d : dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (isValid(grid, newRow, newCol) &&
                !(newRow == parentRow && newCol == parentCol) &&
                grid[newRow][newCol] == target) {
                
                if (dfs(grid, newRow, newCol, row, col, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isValid(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
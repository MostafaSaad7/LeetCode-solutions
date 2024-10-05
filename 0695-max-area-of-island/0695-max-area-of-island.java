class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    int componentLen = dfs(grid, i, j);
                    maxArea = Math.max(componentLen, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (!isValid(grid, row, col))
            return 0;
        grid[row][col] = 0;
        int componentLen = 1;
        for (int[] dir : dirs) {
            componentLen += dfs(grid, row + dir[0], col + dir[1]);
        }
        return componentLen;
    }

    public boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] != 0;
    }
}
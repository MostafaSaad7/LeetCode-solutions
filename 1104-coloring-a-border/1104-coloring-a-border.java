class Solution {
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, 1, 0, -1};
    
    // Return true if this position INSIDE the 2D grid
    public boolean isValid(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length)
            return false;
        if (c < 0 || c >= grid[0].length)
            return false;
        return true;
    }
    
    public void dfs(int r, int c, int[][] grid, boolean[][] visited, int oldColor) {
        if (!isValid(r, c, grid) || visited[r][c] || grid[r][c] != oldColor)
            return;
        
        visited[r][c] = true;
        for (int d = 0; d < 4; d++)
            dfs(r + dr[d], c + dc[d], grid, visited, oldColor);
    }
    
    public void createBoundaries(int[][] grid, boolean[][] visited, int newColor) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c])
                    continue; // NOT part of the CC
                    
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!isValid(nr, nc, grid) || !visited[nr][nc]) {
                        grid[r][c] = newColor; // Boundary
                        break; // Once we know it's a boundary, no need to check other directions
                    }
                }
            }
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(row, col, grid, visited, grid[row][col]);
        createBoundaries(grid, visited, color);
        return grid;
    }
}
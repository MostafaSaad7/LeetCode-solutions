class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid == null || grid.length == 0) return null;
        
        int oldColor = grid[r0][c0];
        dfs(grid, r0, c0, oldColor, color);
        return grid;
    }
    
    public void dfs(int[][] grid, int i, int j, int oldColor, int newColor) {
        if (i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0 || 
            grid[i][j] != oldColor) 
            return;
        
        // Mark as visited by making it negative
        grid[i][j] = -oldColor;
        
        boolean border = false;
        
        // Check if on grid boundary
        if(i == 0 || j == 0 || j == grid[0].length - 1 || i == grid.length - 1) {
            border = true;
        } else {
            // Check neighbors for border condition
            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                // Border if neighbor has different original color
                if(Math.abs(grid[ni][nj]) != oldColor) {
                    border = true;
                    break;
                }
            }
        }
        
        // Recurse to neighbors
        dfs(grid, i+1, j, oldColor, newColor);
        dfs(grid, i-1, j, oldColor, newColor);
        dfs(grid, i, j+1, oldColor, newColor);
        dfs(grid, i, j-1, oldColor, newColor);
        
        // Set final color based on border status
        if(border) {
            grid[i][j] = newColor;
        } else {
            grid[i][j] = oldColor; // Restore original color for non-border
        }
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        // Count if out of bounds OR neighbor is water
                        if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || 
                            grid[ni][nj] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
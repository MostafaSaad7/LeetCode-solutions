class Solution {

    int count;


    public int countSubIslands(int[][] grid1, int[][] grid2) {

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j))
                        count++;
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid1, int[][] grid2, int sr, int sc) {
        if (!isValidIndex(grid2, sr, sc) || grid2[sr][sc] == 0) return true;
        if (grid2[sr][sc] == 1 && grid1[sr][sc] == 0) return false;


        grid2[sr][sc] = 0;
        int[] dx = {0, 1, 0, -1}; // Change here
        int[] dy = {1, 0, -1, 0}; // Change here
        boolean res = true;
        for (int k = 0; k < 4; k++) { // Change here
            int x = sr + dx[k];
            int y = sc + dy[k];
            res &= dfs(grid1, grid2, x, y);
        }


        return res;
    }

    boolean isValidIndex(int[][] grid, int sr, int sc) {
        return sr >= 0 && sr < grid.length && sc >= 0 && sc < grid[0].length;
    }
}
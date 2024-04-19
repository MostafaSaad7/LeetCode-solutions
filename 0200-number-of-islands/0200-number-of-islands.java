class Solution {
    int cc = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cc++;
                }
            }
        }

        return cc;
    }


    void dfs(char[][] grid, int idx1, int idx2) {

        if (!isValidIndex(grid, idx1, idx2) || grid[idx1][idx2] != '1') return;

        grid[idx1][idx2] = '2';

        for (int[] dir : dirs) {
            int r = idx1 + dir[0];
            int c = idx2 + dir[1];
            if (isValidIndex(grid, idx1, idx2))
                dfs(grid, r, c);
        }

    }


    boolean isValidIndex(char[][] grid, int idx1, int idx2) {
        return idx1 >= 0 && idx1 < grid.length && idx2 < grid[idx1].length && idx2 >= 0;
    }
}
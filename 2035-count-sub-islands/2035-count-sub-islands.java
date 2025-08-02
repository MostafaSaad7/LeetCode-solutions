class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int subIslandsCount = 0;
        for (int row = 0; row < grid2.length; row++) {
            for (int col = 0; col < grid2[0].length; col++) {
                if (isVisited(row, col, grid2))
                    continue;
                subIslandsCount += dfs(row, col, grid1, grid2) ? 1 : 0;
            }
        }
        return subIslandsCount;
    }

    boolean dfs(int row, int col, int[][] grid1, int[][] grid2) {
        if (!isValid(row, col, grid2.length, grid2[0].length) || isVisited(row, col, grid2))
            return true;

        boolean result = grid2[row][col] == grid1[row][col];

        grid2[row][col] = -1;

        for (int d = 0; d < 4; d++) {
            int newRow = row + dir[d][0];
            int newCol = col + dir[d][1];
            result &= dfs(newRow, newCol, grid1, grid2);
        }
        return result;
    }

    boolean isValid(int row, int col, int rowsNum, int colsNum) {
        if (row < 0 || row >= rowsNum)
            return false;
        return col >= 0 && col < colsNum;
    }

    boolean isVisited(int row, int col, int[][] grid) {
        return grid[row][col] != 1;
    }

}
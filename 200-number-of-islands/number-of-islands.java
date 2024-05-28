
class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int numberOfIslands = 0;

    public int numIslands(char[][] grid) {

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    dfs(grid, row, column);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (grid[row][column] != '1') return;
        grid[row][column] = '2';


        for (var direction : directions) {
            int newRow = row + direction[0];
            int newCol = column + direction[1];

            if (isValidDirection(grid, newRow, newCol) && grid[newRow][newCol] == '1') dfs(grid, newRow, newCol);

        }


    }


    boolean isValidDirection(char[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length;
    }


}
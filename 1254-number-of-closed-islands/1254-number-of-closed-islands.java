class Solution {
    boolean isClosedIsland;

    public int closedIsland(int[][] grid) {

        int closedIslandCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                isClosedIsland = true;
                if (grid[i][j] == 1 || grid[i][j] == -1) // ignore because it's already visited (-1) or it's a water
                    continue;
                dfs(grid, i, j);
                if (isClosedIsland) {
                    closedIslandCounter++;
                }

            }
        }
        return closedIslandCounter;
    }

    void dfs(int[][] grid, int i, int j) {
        if (!isValidIndecies(grid, i, j)) {
            isClosedIsland = false;
            return;
        } else if (grid[i][j] == 1 || grid[i][j] == -1) {
            return;
        }
        grid[i][j] = -1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newRow = i + dr[k];
            int newCol = j + dc[k];
            dfs(grid, newRow, newCol);
        }


    }

    private boolean isValidIndecies(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return false;
        return true;
    }
}

/*

let assume that you are stop at indices i and j
case: (i,j) == 1 ignore it but
case: (i,j) == 0 traverse all 4 directions but mark it as visited by
put -1 in each cell you visit 

-----------------
for all neigbours 
1- incase that your neighbour exceeded the limits of the matrix --> 
so that's not a connected array 
2- any other cases considered to be connected array 




*/
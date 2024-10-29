import java.util.Arrays;

class Solution {
    private final int[] dirs = {-1, 0, 1};
    
    int dpSol(int[][] grid, int row, int col, int[][] dp) {

        int M = grid.length;
        int N = grid[0].length;
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        
        int maxMoves = 0;
        for (int dir : dirs) {
            int newRow = row + dir;
            int newCol = col + 1;
            
            if (
                    newRow >= 0 && newRow < M && newCol < N && grid[row][col] < grid[newRow][newCol]
            ) {
                maxMoves = Math.max(
                        maxMoves,
                        1 + dpSol(grid, newRow, newCol, dp)
                );
            }
        }
        dp[row][col] = maxMoves;
        return maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int maxMoves = 0;
        for (int i = 0; i < M; i++) {
            int movesRequired = dpSol(grid, i, 0, dp);
            maxMoves = Math.max(maxMoves, movesRequired);
        }
        return maxMoves;
    }
}
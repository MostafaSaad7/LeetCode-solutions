/**
 * Problem: Out of Boundary Paths
 * 
 * Approach: Top-Down Dynamic Programming (Memoization with DFS)
 * - Use DFS to explore all possible paths from the starting position
 * - At each cell, try moving in 4 directions (up, down, left, right)
 * - Base cases:
 *   1. If we go out of bounds -> count as 1 valid path
 *   2. If we run out of moves while still in bounds -> 0 paths
 * - Cache results in a 3D DP array: dp[row][col][remainingMoves]
 * - Initialize DP with -1 to distinguish between "not computed" and "computed as 0"
 * 
 * Time Complexity: O(m * n * maxMove)
 * - There are m * n * maxMove unique states
 * - Each state is computed exactly once due to memoization
 * - Each computation does O(1) work (4 recursive calls to already cached results)
 * 
 * Space Complexity: O(m * n * maxMove)
 * - DP array stores m * n * maxMove integers
 * - Recursion call stack depth is at most O(maxMove) in the worst case
 * - O(m * n * maxMove) dominates
 */
class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] dp;
    final int MOD = 1_000_000_007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        
        // Initialize with -1 to mark uncomputed states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(m, n, maxMove, startRow, startColumn);
    }
    
    private int dfs(int m, int n, int remainingMoves, int row, int col) {
        // Base case: out of bounds means we found a valid path
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        
        // Base case: no moves left and still in bounds means no valid path
        if (remainingMoves == 0) {
            return 0;
        }
        
        // Check if already computed (memoization)
        if (dp[row][col][remainingMoves] != -1) {
            return dp[row][col][remainingMoves];
        }
        
        // Try all 4 directions and sum the paths
        int totalPaths = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            totalPaths = (totalPaths + dfs(m, n, remainingMoves - 1, newRow, newCol)) % MOD;
        }
        
        // Store result in DP cache
        dp[row][col][remainingMoves] = totalPaths;
        return totalPaths;
    }
}
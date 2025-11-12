import java.util.Arrays;

class Solution {
    int[][] dp;
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        
        // Initialize dp array (not matrix!)
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Try all starting positions in first row
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, solve(matrix, 0, j));
        }
        
        return result;
    }
    
    int solve(int[][] matrix, int i, int j) {
        // Base case: reached beyond last row
        if (i == matrix.length)
            return 0;
            
        // Out of bounds
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE / 2;
        
        // Already computed
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        
        // Current cell + min of three options below
        int current = matrix[i][j];
        int down = solve(matrix, i + 1, j);
        int downLeft = solve(matrix, i + 1, j - 1);
        int downRight = solve(matrix, i + 1, j + 1);
        
        dp[i][j] = current + Math.min(down, Math.min(downLeft, downRight));
        return dp[i][j];
    }
}
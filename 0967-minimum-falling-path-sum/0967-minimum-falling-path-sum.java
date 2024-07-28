class Solution {
    int[][] matrixRef;
    int rows;
    int cols;

    public int minFallingPathSum(int[][] matrix) {
        matrixRef = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        Integer[][] dp = new Integer[rows][cols];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            minCost = Math.min(minFallingPathSumAtIndex(0, i, dp), minCost);
        }
        return minCost;
    }

    private int minFallingPathSumAtIndex(int row, int col, Integer[][] dp) {
        if (row == rows || col == -1 || col >= cols)
            return Integer.MAX_VALUE/2;
        if(row==rows-1)
            return matrixRef[row][col];
        if (dp[row][col] != null)
            return dp[row][col];
        int minCost = Integer.MAX_VALUE;
        int choice1= minFallingPathSumAtIndex(row + 1, col - 1, dp);
        int choice2=minFallingPathSumAtIndex(row + 1, col, dp) ;
        int choice3= minFallingPathSumAtIndex(row + 1, col + 1, dp) ;
        minCost = Math.min(minCost, matrixRef[row][col] + Math.min(choice1,Math.min(choice2,choice3)));
        dp[row][col] = minCost;
        return dp[row][col];
    }
}
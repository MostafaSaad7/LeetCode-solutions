class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        // Iterate through the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell contains a 1 and is not in the first row or column
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    // Update the cell value to the minimum of the three neighboring cells plus one
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
                // Add the value of the cell to the count of squares
                count += matrix[i][j];
            }
        }

        return count;
    }
}

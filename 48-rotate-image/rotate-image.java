class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                // Save the bottom-left element
                int temp = matrix[bottom][left + i];
                
                // Move bottom-right to bottom-left
                matrix[bottom][left + i] = matrix[bottom - i][right];
                
                // Move top-right to bottom-right
                matrix[bottom - i][right] = matrix[top][right - i];
                
                // Move top-left to top-right
                matrix[top][right - i] = matrix[top + i][left];
                
                // Move saved bottom-left to top-left
                matrix[top + i][left] = temp;
            }
            
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}

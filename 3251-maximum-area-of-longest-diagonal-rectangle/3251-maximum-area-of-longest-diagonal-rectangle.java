class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquared = 0;
        int maxArea = 0;
        
        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            
            // Calculate diagonal squared (to avoid floating point operations)
            int diagonalSquared = length * length + width * width;
            int area = length * width;
            
            // If we found a larger diagonal, update both values
            if (diagonalSquared > maxDiagonalSquared) {
                maxDiagonalSquared = diagonalSquared;
                maxArea = area;
            } 
            // If diagonal is the same, keep the larger area
            else if (diagonalSquared == maxDiagonalSquared && area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
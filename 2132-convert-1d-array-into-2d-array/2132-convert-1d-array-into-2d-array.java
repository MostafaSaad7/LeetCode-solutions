class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if it's possible to convert the 1D array to a 2D array with the given dimensions
        if (original.length != m * n) {
            return new int[0][0]; // Return an empty 2D array if conversion isn't possible
        }

        // Create the 2D array
        int[][] result = new int[m][n];

        // Fill the 2D array with elements from the original 1D array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
}

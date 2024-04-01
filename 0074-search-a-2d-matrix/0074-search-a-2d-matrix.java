
public class Solution {

    // Constant for the leftmost column index
    private static final int LEFTMOST_COLUMN_INDEX = 0;

    /**
     * Searches for the target element in the given matrix.
     *
     * @param matrix The matrix to search.
     * @param target The target element to find.
     * @return True if the target is found, false otherwise.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Find the row where the target might exist
        int potentialRow = findPotentialRow(matrix, target);

        // Check if the target is in the row (if potentialRow != -1)
        return potentialRow != -1 && binarySearchInRow(matrix[potentialRow], target);
    }

    /**
     * Performs binary search in a sorted row to find the target element.
     *
     * @param sortedRow The sorted row to search.
     * @param target    The target element to find.
     * @return True if the target is found, false otherwise.
     */
    private static boolean binarySearchInRow(int[] sortedRow, int target) {
        int left = 0, right = sortedRow.length - 1;

        // Binary search in the row
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedRow[mid] == target) {
                return true; // Target found
            } else if (sortedRow[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // Target not found
    }

    /**
     * Finds the row where the target element might exist in the matrix.
     *
     * @param matrix The matrix to search.
     * @param target The target element to find.
     * @return The row index if found, -1 otherwise.
     */
    private static int findPotentialRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int rightmostColumnIndex = matrix[0].length - 1;

        // Binary search for the potential row
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][LEFTMOST_COLUMN_INDEX] <= target && matrix[mid][rightmostColumnIndex] >= target) {
                return mid; // Target might be in this row
            } else if (matrix[mid][LEFTMOST_COLUMN_INDEX] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        return -1; // Target not in any potential row
    }
}

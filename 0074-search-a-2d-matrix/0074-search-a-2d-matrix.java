class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = getRow(matrix, target);
        if (row == -1)
            return false;

        return isAtRow(matrix, target, row);

    }

    private static boolean isAtRow(int[][] matrix, int target, int row) {
        int left = 0, right = matrix[row].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        return false;
    }


    public int getRow(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target)
                return mid;
            else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }
}
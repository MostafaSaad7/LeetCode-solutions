class Solution {

    // Main method to return the first and last positions of the target in the sorted array
    public int[] searchRange(int[] nums, int target) {
        // Perform left-biased binary search to find the first occurrence
        int leftMost = binarySearch(nums, target, true);
        // Perform right-biased binary search to find the last occurrence
        int rightMost = binarySearch(nums, target, false);

        // Return both indices as an array
        return new int[] { leftMost, rightMost };
    }

    /**
     * Performs a modified binary search to find either the first or last occurrence of the target.
     *
     * @param nums       Sorted input array
     * @param target     Value to search for
     * @param leftBiased If true, find first occurrence; else, find last occurrence
     * @return           Index of the occurrence, or -1 if not found
     *
     * ⏱ Time Complexity: O(log n)
     *     - Standard binary search on sorted array takes log n time.
     *     - This function is called twice, but total remains O(log n).
     *
     * \U0001f9e0 Space Complexity: O(1)
     *     - Uses only constant extra space (no recursion or data structures).
     */
    private int binarySearch(int[] nums, int target, boolean leftBiased) {
        int result = -1;                // Default if target not found
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevent potential overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                // Target is in the left half
                right = mid - 1;
            } else if (target > nums[mid]) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Found a match
                result = mid;

                if (leftBiased) {
                    // Keep searching left side for first occurrence
                    right = mid - 1;
                } else {
                    // Keep searching right side for last occurrence
                    left = mid + 1;
                }
            }
        }

        return result;
    }
}

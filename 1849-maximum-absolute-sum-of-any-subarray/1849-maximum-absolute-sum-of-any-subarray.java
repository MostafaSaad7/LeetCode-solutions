class Solution {
    /**
     * Calculates the maximum absolute sum of any subarray in the array.
     *
     * Algorithm Summary:
     * ------------------
     * - The sum of any subarray can be represented as the difference between two prefix sums.
     * - To find the maximum absolute subarray sum, track the maximum and minimum prefix sums seen so far.
     * - At each step, calculate the absolute difference between the current prefix sum and both extremes.
     * - Update the result with the largest such difference.
     *
     * Time Complexity: O(n) — Single pass through the array.
     * Space Complexity: O(1) — Uses constant extra space.
     *
     * @param nums input array of integers
     * @return the maximum absolute subarray sum
     */
    public int maxAbsoluteSum(int[] nums) {
        int currentPrefixSum = 0;
        int maxPrevPrefixSum = 0;
        int minPrevPrefixSum = 0;
        int result = 0;

        for (int num : nums) {
            currentPrefixSum += num;

            // Compute the maximum absolute subarray sum ending at this point
            result = Math.max(
                    result,
                    Math.max(
                            Math.abs(currentPrefixSum - minPrevPrefixSum),
                            Math.abs(currentPrefixSum - maxPrevPrefixSum)
                    )
            );

            // Update max and min prefix sums
            maxPrevPrefixSum = Math.max(maxPrevPrefixSum, currentPrefixSum);
            minPrevPrefixSum = Math.min(minPrevPrefixSum, currentPrefixSum);
        }

        return result;
    }
}

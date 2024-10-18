import java.util.Arrays;

class Solution {
    private int count = 0; // to count the number of valid subsets
    private int maxOrRes = 0; // maximum OR result

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Calculate the maximum OR result
        for (int num : nums) {
            maxOrRes |= num; // maxOrRes now contains the OR of all elements
        }

        // Step 2: Use backtracking to count the subsets whose OR equals maxOrRes
        backtrack(nums, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int currentIdx, int currentOrRes) {

        if (currentIdx == nums.length) {
            // Check if the current OR equals the maximum OR
            if (currentOrRes == maxOrRes) {
                count++;
            }
            return;
        }

        // Include the current number in the subset
        backtrack(nums, currentIdx + 1, currentOrRes | nums[currentIdx]);

        // Exclude the current number from the subset
        backtrack(nums, currentIdx + 1, currentOrRes);
    }
}
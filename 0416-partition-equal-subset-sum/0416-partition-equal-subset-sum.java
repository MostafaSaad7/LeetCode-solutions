import java.util.Arrays;

class Solution {

    Boolean[][] mem; // Used Boolean to differentiate between initialized and uninitialized values

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0)
            return false;

        mem = new Boolean[nums.length][sum / 2 + 1]; // Initialize mem with Boolean
        return isSubsetHasASum(nums, sum / 2, 0);
    }

    private boolean isSubsetHasASum(int[] nums, int sum, int i) {

        if (sum < 0)
            return false;
        if (sum == 0)
            return true;
        if (i == nums.length)
            return false;

        // Memoization check
        if (mem[i][sum] != null)
            return mem[i][sum];

        // Recursively check for subset sum
        boolean result = isSubsetHasASum(nums, sum, i + 1) || isSubsetHasASum(nums, sum - nums[i], i + 1);

        // Store the result in the memoization array
        mem[i][sum] = result;

        return result;
    }
}
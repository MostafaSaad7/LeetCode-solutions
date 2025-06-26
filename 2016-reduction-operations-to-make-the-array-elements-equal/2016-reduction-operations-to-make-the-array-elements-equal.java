import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int operations = 0;
        int count = 0;

        // Iterate from the end to the start
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                count++; // New unique value transition
            }
            operations += count;
        }

        return operations;
    }
}

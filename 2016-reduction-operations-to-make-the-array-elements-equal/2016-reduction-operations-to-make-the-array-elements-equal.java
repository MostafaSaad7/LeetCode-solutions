import java.util.Arrays;
class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int operations = 0;
        
        // Process from largest to smallest (reverse iteration)
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                operations += (n - i);
            }
        }
        return operations;
    }
}
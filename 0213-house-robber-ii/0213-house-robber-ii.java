class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Rob houses from index 0 to n-2
        int rob1 = helper(nums, 0, nums.length - 2);
        // Rob houses from index 1 to n-1
        int rob2 = helper(nums, 1, nums.length - 1);

        // Return the maximum of the two scenarios
        return Math.max(rob1, rob2);
    }

    private static int helper(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;

        for (int i = start; i <= end; i++) {
            int maxChoice = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = maxChoice;
        }

        return rob2;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2})); // Output should be 3
    }
}

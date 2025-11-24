class Solution {
    private int[] nums;
    // dp[i][j] stores the LIS length from index i onwards, 
    // given that the previous picked element was at index j-1.
    // Size is N x (N+1) to accommodate the dummy index 0 (for prev_idx = -1).
    private Integer[][] memo; 

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        this.nums = nums;
        int n = nums.length;
        // The first dimension is for the current index 'i' (0 to n-1).
        // The second dimension is for the previous index 'prev_idx' (0 to n).
        // 0 means no previous element (-1). 1 to n means indices 0 to n-1.
        memo = new Integer[n][n + 1];

        // Start the recursion: 
        // i = 0 (start at the first element)
        // prev_idx = 0 (representing -1, meaning no previous element)
        return solve(0, 0);
    }

    /**
     * Finds the length of the LIS from index 'i' onwards, 
     * given that the last element taken was at 'prev_idx - 1'.
     * * @param i The current index being considered.
     * @param prev_idx The shifted index of the previously taken element (0 for -1, 1 for 0, etc.).
     * @return The length of the LIS.
     */
    private int solve(int i, int prev_idx) {
        // Base Case: Reached the end of the array.
        if (i == nums.length) {
            return 0;
        }

        // Check Memoization
        if (memo[i][prev_idx] != null) {
            return memo[i][prev_idx];
        }

        // --- 1. Leave Option (Not Pick nums[i]) ---
        // LIS length is the result of moving to the next element (i+1) 
        // while keeping the same previous element.
        int leave = solve(i + 1, prev_idx);

        // --- 2. Pick Option (Take nums[i]) ---
        int pick = 0;
        
        // Determine the actual index of the previously taken element
        int actual_prev_idx = prev_idx - 1;

        // Check Validity:
        // If actual_prev_idx is -1 (no element picked yet) 
        // OR the current element is strictly greater than the previously picked element.
        if (actual_prev_idx == -1 || nums[i] > nums[actual_prev_idx]) {
            // LIS length increases by 1. 
            // The new previous index becomes 'i', which is shifted to 'i + 1' for the state.
            pick = 1 + solve(i + 1, i + 1);
        }

        // Result is the maximum of the two choices
        int result = Math.max(leave, pick);
        
        // Store and return the result
        memo[i][prev_idx] = result;
        return result;
    }
}
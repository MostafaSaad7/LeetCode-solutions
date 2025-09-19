class Solution {
    int[] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];

        // ensure every dp[i] is computed
        for (int i = 0; i < n; i++) {
            solve(nums, i);
        }

        // now scan dp to get the max
        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }

    private int solve(int[] nums, int i) {
        if (dp[i] != 0) return dp[i];

        int maxSubseq = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                maxSubseq = Math.max(maxSubseq, solve(nums, j));
            }
        }

        dp[i] = maxSubseq + 1; // LIS starting at i
        return dp[i];
    }
}

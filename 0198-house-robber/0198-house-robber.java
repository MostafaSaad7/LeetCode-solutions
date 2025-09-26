import java.util.Arrays;

class Solution {
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums);

    }

    public int solve(int idx, int[] nums) {

        if (idx >= nums.length)
            return 0;
        
        if (dp[idx] != -1)
            return dp[idx];

        int skip = solve(idx + 1, nums);
        int take = nums[idx] + solve(idx + 2, nums);

        return dp[idx] = Math.max(skip, take);
    }
}
class Solution {

    int[] numsG;

    public int combinationSum4(int[] nums, int target) {
        numsG = nums;
        Integer[] dp = new Integer[target + 1];

        return dfs(target, dp);
    }

    private int dfs(int target, Integer[] dp) {

        if (target == 0)
            return 1;

        if (target < 0)
            return 0;
        // memory
        if (dp[target] != null)
            return dp[target];
        int total = 0;
        for (int num : numsG) {
            total += dfs(target - num,dp);
        }

        dp[target]=total;
        return total;
    }
}
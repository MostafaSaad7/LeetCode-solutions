import java.util.Arrays;

class Solution {
    int[][] dp;
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        
        dp = new int[n + 2][n + 2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(newNums, 1, n);
    }
    
    int solve(int[] nums, int left, int right) {
        if (left > right)
            return 0;
            
        if (dp[left][right] != -1)
            return dp[left][right];
        
        int maxCoins = 0;
        
        // Try bursting each balloon last in this range
        for (int index = left; index <= right; index++) {
            int cost = nums[index] * nums[left - 1] * nums[right + 1];
            int leftResult = solve(nums, left, index - 1);
            int rightResult = solve(nums, index + 1, right);
            
            maxCoins = Math.max(maxCoins, cost + leftResult + rightResult);
        }
        
        return dp[left][right] = maxCoins;
    }
}
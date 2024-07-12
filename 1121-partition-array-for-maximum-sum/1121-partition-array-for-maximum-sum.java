import java.util.Arrays;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 0);
        for (int start = len - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(start + k, len);
            for (int endIndex = start; endIndex < end; endIndex++) {
                currMax = Math.max(currMax, arr[endIndex]);
                dp[start] = Math.max(dp[start], currMax * (endIndex - start + 1) + dp[endIndex + 1]);
            }
        }
        return dp[0];
    }
}
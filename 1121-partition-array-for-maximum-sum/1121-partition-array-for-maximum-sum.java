class Solution {
    int[] dp;
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve(0, arr, k);
    }
    
    int solve(int indx, int[] arr, int k) {
        if (indx >= arr.length) return 0;
        if (dp[indx] != -1) return dp[indx];
        
        int max = 0;
        int result = 0;
        
        for (int endAt = indx; endAt < indx + k; endAt++) {
            if (endAt >= arr.length) break;
            max = Math.max(max, arr[endAt]);
            int len = endAt - indx + 1;
            result = Math.max(result, max * len + solve(endAt + 1, arr, k));
        }
        
        dp[indx] = result;
        return dp[indx];
    }
}
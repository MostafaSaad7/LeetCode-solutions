import java.util.Arrays;

class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m + 1][n + 1];
        // fill dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, text1, text2);
    }

    int solve(int idx1, int idx2, String text1, String text2) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + solve(idx1 + 1, idx2 + 1, text1, text2);
        } else {
            int op1 = solve(idx1 + 1, idx2, text1, text2);
            int op2 = solve(idx1, idx2 + 1, text1, text2);
            return dp[idx1][idx2] = Math.max(op1, op2);
        }
    }
}
import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int num = 1; num < n + 1; num++) {
            dp[num]=n; // worst case ones 
            for (int numSquare = 1; numSquare <= num; numSquare++) {
                int square = numSquare * numSquare;
                if (num - square < 0) break;
                dp[num] = Math.min(dp[num], 1 + dp[num - square]);
            }
        }
        return dp[n];
    }
}
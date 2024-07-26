import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {

        int[] dp = new int[target + 1]; // number of way to get the target value
        dp[0] = 1; // if target is zero so we have only one way (base case )

        for (int dice = 0; dice < n; dice++) {
            int[] nextDPRow = new int[target + 1];
            Arrays.fill(nextDPRow, 0);
            for (int face = 1; face < k + 1; face++) {
                for (int total = face; total < target + 1; total++) {
                    nextDPRow[total] = (nextDPRow[total] + dp[total - face]) % MOD;

                }

            }

            dp = nextDPRow;
        }

        return dp[target];
    }

}

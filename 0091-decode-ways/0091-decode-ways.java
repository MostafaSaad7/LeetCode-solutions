import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }

    int dfs(String s, int currentIdx, int[] dp) {
        if (currentIdx >= s.length())
            return 1;
        if (dp[currentIdx] != -1)
            return dp[currentIdx];
        if (s.charAt(currentIdx) == '0')
            return 0;

        int count = dfs(s, currentIdx + 1, dp);
        if (currentIdx + 1 < s.length() && Integer.valueOf(s.substring(currentIdx, currentIdx + 2)) < 27)
            count += dfs(s, currentIdx + 2, dp);

        dp[currentIdx] = count;
        return count;
    }
}
import java.util.Arrays;

class Solution {
    int[] dp;
    String input;
    
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        input = s;
        return solve(0);
    }
    
    public int solve(int index) {
        if (index >= input.length())
            return 1;
        
        if (dp[index] != -1)
            return dp[index];
        
        int count = 0;
        
        // Try taking 1 character
        if (input.charAt(index) != '0') {
            count += solve(index + 1);
        }
        
        // Try taking 2 characters
        if (index + 1 < input.length()) {
            int twoDigit = Integer.parseInt(input.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += solve(index + 2);
            }
        }
        
        dp[index] = count;
        return dp[index];
    }
}
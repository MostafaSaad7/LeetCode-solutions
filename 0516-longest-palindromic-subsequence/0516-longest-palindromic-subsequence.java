class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];


        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {

                if (s.charAt(i) == s.charAt(j))
                    memo[i][j] = 2 + memo[i-1][j+1];
                else
                    memo[i][j] = Math.max(memo[i-1][j],memo[i][j+1]);
            }

        }


        return memo[s.length()-1][0];
    }
}
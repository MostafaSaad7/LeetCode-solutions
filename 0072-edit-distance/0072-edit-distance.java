import java.util.Arrays;

class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word2, 0, 0);
    }
    private int dp(String word1, String word2, int i, int j) {
        if (i == word1.length() || j == word2.length()) {
            return word1.length() - i + word2.length() - j;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(word1, word2, i + 1, j + 1);
    }
    int insert = dp(word1, word2, i, j + 1) + 1;
    int delete = dp(word1, word2, i + 1, j) + 1;
    int replace = dp(word1, word2, i + 1, j + 1) + 1;
    return memo[i][j] = Math.min(insert, Math.min(delete, replace));
    }

}
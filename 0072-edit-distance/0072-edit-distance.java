class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int r = word2.length();
        int[][] memory = new int[m + 1][r + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            memory[i][r] = m - i; // If word2 is empty, remove all characters of word1
        }
        for (int j = 0; j <= r; j++) {
            memory[m][j] = r - j; // If word1 is empty, insert all characters of word2
        }

        // Fill the DP table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = r - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    memory[i][j] = memory[i + 1][j + 1];
                } else {
                    int insert = 1 + memory[i][j + 1];
                    int delete = 1 + memory[i + 1][j];
                    int replace = 1 + memory[i + 1][j + 1];
                    memory[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return memory[0][0];
    }
}

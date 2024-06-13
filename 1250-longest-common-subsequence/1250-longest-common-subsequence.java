import java.util.Arrays;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] arrRef = new int[len1 + 1][len2 + 1];

        // Initialize the memoization array with -1
        for (int[] row : arrRef) {
            Arrays.fill(row, 0);
        }

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    arrRef[i][j] = 1 + arrRef[i + 1][j + 1];
                } else {

                    arrRef[i][j] = Math.max(arrRef[i + 1][j], arrRef[i][j + 1]);
                }
            }
        }
        return arrRef[0][0];
    }


}

import java.util.Arrays;

class Solution {
    String text1RefCopy;
    String text2RefCopy;

    int[][] arrRef;

    public int longestCommonSubsequence(String text1, String text2) {
        text1RefCopy = text1;
        text2RefCopy = text2;
        int len1 = text1.length();
        int len2 = text2.length();
        arrRef = new int[len1][len2];
        
        // Initialize the memoization array with -1
        for (int[] row : arrRef) {
            Arrays.fill(row, -1);
        }

        return getLongestCommonSubsequence(0, 0);
    }

    int getLongestCommonSubsequence(int idx1, int idx2) {
        if (idx1 == text1RefCopy.length() || idx2 == text2RefCopy.length()) {
            return 0;
        }

        if (arrRef[idx1][idx2] != -1) {
            return arrRef[idx1][idx2];
        }

        if (text1RefCopy.charAt(idx1) == text2RefCopy.charAt(idx2)) {
            arrRef[idx1][idx2] = 1 + getLongestCommonSubsequence(idx1 + 1, idx2 + 1);
        } else {
            int choice1 = getLongestCommonSubsequence(idx1 + 1, idx2);
            int choice2 = getLongestCommonSubsequence(idx1, idx2 + 1);
            arrRef[idx1][idx2] = Math.max(choice1, choice2);
        }

        return arrRef[idx1][idx2];
    }
}

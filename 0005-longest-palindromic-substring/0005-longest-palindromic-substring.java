class Solution {
    String str;
    Boolean[][] memo;

    public String longestPalindrome(String s) {
        str = s;
        int maxLen = 1;
        int start = 0;
        memo = new Boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j) && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(int start, int end) {
        if (start >= end)
            return true;
        if (memo[start][end] != null)
            return memo[start][end];
        if (str.charAt(start) == str.charAt(end)) {
            memo[start][end] = isPalindrome(start + 1, end - 1);
            return memo[start][end];
        }
        memo[start][end] = false;
        return false;
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }


    int dfs(String s, int start, int end, Integer[][] memory) {
        if (start > end) {
            return 0;
        }
        if (memory[start][end] != null) {
            return memory[start][end];
        }
        int longestPalSubSeq = 0;
        if (s.charAt(start) == s.charAt(end)) {
            int length = start == end ? 1 : 2; // same character 
            longestPalSubSeq = length + dfs(s, start + 1, end - 1, memory);
        } else {
            longestPalSubSeq = Math.max(dfs(s, start + 1, end, memory), dfs(s, start, end - 1, memory));
        }
        memory[start][end] = longestPalSubSeq;
        return memory[start][end];
    }
}
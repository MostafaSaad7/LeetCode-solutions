class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // odd length
            String p1 = expand(s, i, i);
            // even length
            String p2 = expand(s, i, i + 1);
            if (p1.length() > res.length()) res = p1;
            if (p2.length() > res.length()) res = p2;
        }
        return res;
    }

    private String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}

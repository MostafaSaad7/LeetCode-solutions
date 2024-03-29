class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;

        int sPointer = 0;
        int tPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }

        return sPointer == s.length();

    }
}
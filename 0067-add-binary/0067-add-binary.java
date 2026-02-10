class Solution {
    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        int n = a.length();
        int m = b.length();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            if (i < n) carry += a.charAt(n - 1 - i) - '0';
            if (i < m) carry += b.charAt(m - 1 - i) - '0';
            result.append(carry % 2);
            carry /= 2;
        }
        if (carry != 0)
            result.append(carry);
        return result.reverse().toString();
    }
}
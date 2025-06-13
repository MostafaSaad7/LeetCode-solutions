class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if both strings are made of the same repeated base
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; // No common base
        }

        // Step 2: Compute GCD of lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: Return the substring of str1 with length = GCD
        return str1.substring(0, gcdLength);
    }

    // Euclidean Algorithm to compute GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

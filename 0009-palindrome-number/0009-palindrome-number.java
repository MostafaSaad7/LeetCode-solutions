class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));

        return stringBuilder.toString().equals(stringBuilder.reverse().toString());

    }
}
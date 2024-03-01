class Solution {
    public String maximumOddBinaryNumber(String s) {

        int length = s.length(); // Specify the desired length
        int ones = 0;
        StringBuilder result = new StringBuilder();
        result.append("0".repeat(length));
        for (char c : s.toCharArray()) {
            ones += c == '1' ? 1 : 0;
        }
        result.setCharAt(length-1, '1');
        ones--;
        int i = 0 ;

        while (ones-->0)
        {
            result.setCharAt(i++,'1');
        }

        return result.toString();
    }
}
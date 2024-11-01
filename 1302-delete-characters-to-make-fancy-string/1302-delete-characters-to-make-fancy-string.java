class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        char prevChar = s.charAt(0);
        int freq = 1;
        result.append(prevChar);
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == prevChar) {

                freq++;
            } else {

                prevChar = s.charAt(i);
                freq = 1;
            }
            if (freq < 3) {
                result.append(s.charAt(i));
            }

        }


        return result.toString();
    }
}
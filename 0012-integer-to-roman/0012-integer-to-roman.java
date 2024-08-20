class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0; // start from the largest number

        while (num > 0) {

            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);

            }

            i++;


        }

        return result.toString();
    }
}
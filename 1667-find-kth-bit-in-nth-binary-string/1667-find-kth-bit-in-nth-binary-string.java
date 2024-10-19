class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder currentNumber = new StringBuilder("0");

        for (int i = 1; i <= n; i++) {

            String numberBeforeConversion = currentNumber.toString();
            String invertedNumber = invert(numberBeforeConversion);
            StringBuilder reversedNumber = new StringBuilder(invertedNumber).reverse();
            currentNumber = new StringBuilder(numberBeforeConversion).
                    append("1").
                    append(reversedNumber);
        }


        return currentNumber.charAt(k - 1);
    }

    private String invert(String numberBeforeConversion) {
        StringBuilder result = new StringBuilder();

        for (char c : numberBeforeConversion.toCharArray()) {
            result.append(c ^ '1');

        }

        return result.toString();
    }


}
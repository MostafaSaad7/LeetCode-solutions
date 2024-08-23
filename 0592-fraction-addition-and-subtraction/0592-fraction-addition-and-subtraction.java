class Solution {
    public String fractionAddition(String expression) {
        // Initialize numerator and denominator for the result
        int numerator = 0;
        int denominator = 1;

        // Use regular expression to match fractions in the input string
        int i = 0, n = expression.length();
        while (i < n) {
            // Determine the sign of the fraction
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            // Extract the numerator
            int numStart = i;
            while (i < n && expression.charAt(i) != '/') i++;
            int num = Integer.parseInt(expression.substring(numStart, i));

            // Move to the denominator
            i++;
            int denomStart = i;
            while (i < n && Character.isDigit(expression.charAt(i))) i++;
            int denom = Integer.parseInt(expression.substring(denomStart, i));

            // Add the fraction to the result
            numerator = numerator * denom + sign * num * denominator;
            denominator *= denom;

            // Reduce the fraction to its simplest form
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        // Return the result as a fraction
        return numerator + "/" + denominator;
    }

    // Helper method to compute the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to safely handle edge case: Integer.MIN_VALUE
        long N = n;

        // If the exponent is negative, flip x and make the exponent positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        // Initialize result as 1.0 (multiplicative identity)
        double result = 1.0;

        // Exponentiation by squaring
        while (N > 0) {
            // If the current bit of N is set (odd number), multiply result by x
            if ((N % 2) == 1) {
                result *= x;
            }

            // Square x for the next bit
            x *= x;

            // Move to the next bit of the exponent
            N /= 2;
        }

        // Return the final result
        return result;
    }
}

/*
Time Complexity: O(log n)
- We divide the exponent N by 2 in each iteration.
- So the number of loop iterations is proportional to log₂(n).

Space Complexity: O(1)
- No recursion or extra memory used.
- Only a few primitive variables are declared and reused.
*/

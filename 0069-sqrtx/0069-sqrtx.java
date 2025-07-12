class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double left = 0;
        double right = x;
        double mid = 0; // Initialize mid outside the loop

        // Using a small epsilon for double comparison
        // The loop continues as long as the difference between left and right is greater than EPSILON
        final double EPSILON = 1e-9; 

        while (Math.abs(left - right) > EPSILON) {
            mid = left + (right - left) / 2;

            if ((mid * mid) > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        

        return (int) (mid + EPSILON); 
    }
}
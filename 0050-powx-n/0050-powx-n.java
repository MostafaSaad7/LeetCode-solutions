class Solution {
    public double myPow(double x, int n) {

        double result = superPower(x, n);
        return n < 0 && result != 0 ? 1 / result : result;
    }

    private double superPower(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;

        double result = superPower(x, n / 2);
        result = result * result;
        result = n % 2 == 0 ? result : result * x;
        return result;
    }
}
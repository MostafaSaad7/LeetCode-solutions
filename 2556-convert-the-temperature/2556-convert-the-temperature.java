class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin = Double.parseDouble(String.format("%.5f",celsius + 273.15));
        double fahrenheit = Double.parseDouble(String.format("%.5f",celsius * 1.80 + 32.00));
        return new double[]{kelvin, fahrenheit};
    }
}
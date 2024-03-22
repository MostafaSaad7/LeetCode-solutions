class Solution {
    public int romanToInt(String s) {
        // Store the mapping of Roman numerals to their corresponding values in an array
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int result = 0;
        int prevValue = values[s.charAt(0) - 'A']; // Initialize prevValue with the value of the first character
        
        for (int i = 1; i < s.length(); i++) {
            int currentValue = values[s.charAt(i) - 'A'];
            
            // If the current numeral is part of a subtractive pair, subtract its value
            if (prevValue < currentValue) {
                result -= prevValue;
            } else {
                result += prevValue;
            }
            
            // Update prevValue for the next iteration
            prevValue = currentValue;
        }
        
        // Add the value of the last numeral
        result += prevValue;
        
        return result;
    }
}

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Create a HashMap to store the mapping of Roman numerals to values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        int result = 0;

        // Populate the HashMap with the Roman numerals and their corresponding values
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            int currentNumberVal = romanMap.get(s.charAt(i));
            int nextNumberValue = romanMap.get(s.charAt(i + 1));
            if (currentNumberVal < nextNumberValue) {
                result -= currentNumberVal;
            } else {
                result += currentNumberVal;
            }
        }
        result += romanMap.get(s.charAt(s.length()-1));
        return result;
    }
}
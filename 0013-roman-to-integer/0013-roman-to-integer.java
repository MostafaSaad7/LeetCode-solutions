import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romantoIntegersMap = new HashMap<>();

        romantoIntegersMap.put('I', 1);
        romantoIntegersMap.put('V', 5);
        romantoIntegersMap.put('X', 10);
        romantoIntegersMap.put('L', 50);
        romantoIntegersMap.put('C', 100);
        romantoIntegersMap.put('D', 500);
        romantoIntegersMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romantoIntegersMap.get(s.charAt(i)) < romantoIntegersMap.get(s.charAt(i + 1)))
                result -= romantoIntegersMap.get(s.charAt(i));
            else
                result += romantoIntegersMap.get(s.charAt(i));
        }

        return result;

    }
}
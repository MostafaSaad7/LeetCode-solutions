import java.util.HashMap;
import java.util.Objects; // Although not strictly needed for this corrected logic, good to have if you intend to use it.

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // For sMap
            char sChar = s.charAt(i);
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);

            // For tMap
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        // The most robust way to check if two frequency maps are equal is to use .equals()
        // HashMap's equals method correctly compares key-value pairs.
        return sMap.equals(tMap);
    }
}
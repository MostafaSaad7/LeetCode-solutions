import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        HashSet<Character> mappedToItBefore = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (characterHashMap.containsKey(cS) && characterHashMap.get(cS) != cT)
                return false;
            if (!characterHashMap.containsKey(cS) && mappedToItBefore.contains(cT)) 
                return false;
            characterHashMap.put(cS, cT);
            mappedToItBefore.add(cT);
        }

        return true;
    }
}
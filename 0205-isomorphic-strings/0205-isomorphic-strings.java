import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> characterHashMapS = new HashMap<>();
        HashMap<Character, Character> characterHashMapT = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if ((characterHashMapS.containsKey(cS) && characterHashMapS.get(cS) != cT) || (characterHashMapT.containsKey(cT) && characterHashMapT.get(cT) != cS))
                return false;

            characterHashMapS.put(cS, cT);
            characterHashMapT.put(cT, cS);
        }

        return true;
    }
}
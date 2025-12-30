import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0 ;
        int left=0;

        Map<Character,Integer> characterToIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer index = characterToIndexMap.get(s.charAt(i));
            if (index!=null&&index>=left && index<=i)
            {
                 left=index+1;
            }
            result=Math.max(result,i-left+1);
            characterToIndexMap.put(s.charAt(i),i);
        }
        return result;
    }
}
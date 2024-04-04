import java.util.Map;
import java.util.Stack;

class Solution {
    public int maxDepth(String s) {

        int paranthesesCounter = 0;
        int maxDepth = 0;

        for (Character c : s.toCharArray()) {
            if ('(' == c)
                paranthesesCounter++;
            else if (')' == c) {
                paranthesesCounter--;
            }
            maxDepth = Math.max(maxDepth, paranthesesCounter);
        }

        return maxDepth;
    }
}

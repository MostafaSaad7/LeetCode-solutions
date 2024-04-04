import java.util.Map;
import java.util.Stack;

class Solution {
    public int maxDepth(String s) {

        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for (Character c : s.toCharArray()) {
            if ('(' == c)
                stack.push(c);
            else if (')' == c && !stack.empty()) {
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }

        return maxDepth;
    }
}

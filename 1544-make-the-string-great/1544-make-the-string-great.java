import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        int CONST_DIFF = Math.abs('A' - 'a');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && Math.abs(stack.peek() - c) == CONST_DIFF) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        for (char c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
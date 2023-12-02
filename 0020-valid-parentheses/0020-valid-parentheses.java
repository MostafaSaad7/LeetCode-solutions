class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isOpenParent(c)) {
                stack.push(c);
            } else if (!stack.empty() && checkParenthesesValidation(c, stack.peek())) {
                stack.pop();
            } else return false;

        }
        
        return stack.empty();


    }

    private boolean checkParenthesesValidation(Character c, Character stackTop) {
        return c.equals('}') && stackTop.equals('{')
                || c.equals(']') && stackTop.equals('[')
                || c.equals(')') && stackTop.equals('(');

    }

    private boolean isOpenParent(Character c) {
        return "({[".contains(c.toString());
    }
}


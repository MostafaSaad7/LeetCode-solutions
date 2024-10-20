

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (Character character : expression.toCharArray()) {
            if (character == ')') {

                List<Boolean> values = new LinkedList<>();
                while (stack.peek() != '(') {
                    values.add(stack.peek() == 't');
                    stack.pop();
                }
                stack.pop();// pop (

                Character operation = stack.pop();

                Boolean result = evaluate(operation, values);

                stack.push(result == true ? 't' : 'f');
            } else if (character != ',') {
                stack.push(character);
            }

        }


        return stack.peek() == 't';
    }

    private Boolean evaluate(Character operation, List<Boolean> values) {

        if (operation == '!')
            return !values.get(0);

        else if (operation == '|') {
            for (Boolean val : values) {
                if (val)
                    return val;
            }
            return false;
        } else {
            for (Boolean val : values) {
                if (!val)
                    return val;
            }
            return true;
        }
    }
}
class Solution {
    String operators = "+-/*";
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String value : tokens) {

            if (isOperator(value)){
                calcOperation(stack,value);
            }
            else
            {
                stack.push(Integer.parseInt(value));
            }

        }

        return stack.pop();


    }

    private void calcOperation(Stack<Integer> stack, String value) {
        int number1 = stack.pop();
        int number2 = stack.pop();
        if (value.equals("+")) {
            stack.add(number1 + number2);
        } else if (value.equals("-")) {
            stack.add(number2 - number1);
        } else if (value.equals("*")) {
            stack.add(number1 * number2);
        } else  {

            stack.add(number2 / number1);
        }
    }

    private boolean isOperator(String value) {
        return operators.contains(value);
    }
}
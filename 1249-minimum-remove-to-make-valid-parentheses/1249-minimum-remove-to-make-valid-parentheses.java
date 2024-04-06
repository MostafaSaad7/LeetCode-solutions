import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);

            } else if (s.charAt(i) == ')') {
                if (!stack.empty()) stack.pop();
                else
                    res.setCharAt(i, '*');
            }
        }

        while (!stack.empty())
        {
            res.setCharAt(stack.pop(), '*');
        }


       return res.toString().replace("*","");

    }
}
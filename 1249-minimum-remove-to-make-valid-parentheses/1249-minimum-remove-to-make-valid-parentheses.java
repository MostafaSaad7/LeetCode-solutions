import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringWithOpen = new StringBuilder();
        int openParenthesis = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                openParenthesis++;
            } else if (s.charAt(i) == ')') {
                if (openParenthesis == 0) continue; // to matching open Parenthesis
                openParenthesis--;
            }

            stringWithOpen.append(s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();

        for (int i = stringWithOpen.length() - 1; i >= 0; i--) {

            if (stringWithOpen.charAt(i) == '(' && openParenthesis > 0) {
                openParenthesis--;
                continue;
            }
            result.append(stringWithOpen.charAt(i));
        }

        return result.reverse().toString();

    }
}
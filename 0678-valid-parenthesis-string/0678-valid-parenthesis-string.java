import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openParantStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openParantStack.push(i);
            else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (!openParantStack.empty()) openParantStack.pop();
                else if (!starStack.empty()) {
                    starStack.pop();

                } else
                    return false;


            }
        }
        while (!openParantStack.empty() && !starStack.empty()) {
            if (starStack.pop() < openParantStack.pop()) return false;
            
        }


        return openParantStack.empty();
    }
}
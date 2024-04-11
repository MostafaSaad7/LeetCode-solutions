import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        
        // Handle edge case: if k equals to the length of the number, return "0"
        if (k == len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        
        // Iterate through the digits of the number
        for (int i = 0; i < len; i++) {
            char currentDigit = num.charAt(i);
            
            // Whenever a digit is less than the top of the stack and k > 0, pop elements from the stack
            while (k > 0 && !stack.isEmpty() && stack.peek() > currentDigit) {
                stack.pop();
                k--;
            }
            
            stack.push(currentDigit);
        }
        
        // Pop remaining elements if k > 0
        for (int i = 0; i < k; i++) {
            stack.pop();           
        }
        
        // Construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        
        sb.reverse();
        
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}

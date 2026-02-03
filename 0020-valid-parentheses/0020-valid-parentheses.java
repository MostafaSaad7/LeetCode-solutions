class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put('(', ')');
        openToClose.put('[', ']');
        openToClose.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // If opening bracket → push
            if (openToClose.containsKey(c)) {
                stack.push(c);
            } 
            else {
                if (stack.isEmpty()) return false;

                char lastOpen = stack.pop();
                if (openToClose.get(lastOpen) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

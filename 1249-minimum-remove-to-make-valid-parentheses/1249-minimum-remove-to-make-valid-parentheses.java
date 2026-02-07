class Solution {
    private static final Character OPEN = '(';
    private static final Character CLOSE = ')';
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> excludedIndices = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar==OPEN)
                stack.push(i);
            else if (currentChar==CLOSE ) {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    excludedIndices.add(i);
            }
        }

        while (!stack.isEmpty()) excludedIndices.add(stack.pop());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (excludedIndices.contains(i)) continue;
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
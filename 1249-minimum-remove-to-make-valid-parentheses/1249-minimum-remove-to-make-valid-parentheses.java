class Solution {
    private static final Character OPEN = '(';
    private static final Character CLOSE = ')';
    // Documentation generated using AI tool
    /**
     * Time Complexity: O(n)
     *   - First pass: O(n) - iterate through string once
     *   - Second pass: O(n) - iterate through sb once
     *   - Reverse: O(n) - reverse the result
     *   - Total: O(n) + O(n) + O(n) = O(n)
     *
     * Space Complexity: O(n)
     *   - StringBuilder sb: O(n) - stores first pass result
     *   - StringBuilder result: O(n) - stores final result
     *   - Total: O(n)
     *
     * Approach: Two-Pass Solution
     *   - Pass 1 (left to right): Remove unmatched ')'
     *   - Pass 2 (right to left): Remove unmatched '('
     */
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        /*
         * ═══════════════════════════════════════════════════════════
         * FIRST PASS: Remove unmatched ')' (left to right)
         * ═══════════════════════════════════════════════════════════
         * 
         * Why left to right?
         * - We can detect unmatched ')' immediately
         * - If we see ')' but no '(' came before → unmatched!
         * 
         * Example: "a)b(c)d"
         *           ↑
         *      No '(' before this → remove it
         */
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (currentChar == OPEN) {
                // Found '(' → might need matching ')' later
                count++;
            } else if (currentChar == CLOSE && count > 0) {
                // Found ')' and we have unmatched '(' → they match!
                count--;
            } else if (currentChar == CLOSE && count == 0) {
                // Found ')' but no '(' to match → skip this ')'
                continue;
            }
            
            sb.append(currentChar);
        }
        
        /*
         * After first pass:
         * - All unmatched ')' are removed
         * - 'count' = number of unmatched '(' remaining
         * 
         * Example: "(a(b)" → sb = "(a(b)", count = 1
         *           ↑
         *      This '(' has no matching ')'
         */
        
        /*
         * ═══════════════════════════════════════════════════════════
         * SECOND PASS: Remove unmatched '(' (right to left)
         * ═══════════════════════════════════════════════════════════
         * 
         * Why right to left?
         * - We need to remove RIGHTMOST unmatched '(' first
         * - Removing from left would break valid pairs
         * 
         * Example: "(a(b)" with count=1
         *           ↑
         *      Remove this one (leftmost unmatched)
         *      But going right to left finds it correctly!
         * 
         *      i=4: ')' → keep
         *      i=3: 'b' → keep
         *      i=2: '(' → count>0, remove, count=0
         *      i=1: 'a' → keep
         *      i=0: '(' → count=0, keep
         *      
         *      Result (reversed): "(a)b" → Correct!
         */
        StringBuilder result = new StringBuilder();
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (count > 0 && sb.charAt(i) == OPEN) {
                // Found '(' and we still have unmatched ones → skip
                count--;
                continue;
            }
            result.append(sb.charAt(i));
        }
        
        /*
         * Result is reversed because we iterated backwards
         * Example: "(ab)" → result = ")ba(" → reverse → "(ab)"
         */
        return result.reverse().toString();
    }
}
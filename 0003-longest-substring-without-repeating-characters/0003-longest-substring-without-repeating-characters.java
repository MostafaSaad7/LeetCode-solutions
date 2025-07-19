import java.util.HashSet;

class Solution {
    /*
     * Approach:
     * ----------
     * We use the sliding window technique to maintain a substring with unique characters.
     * 
     * - A HashSet is used to keep track of characters currently in the window [start, end].
     * - We expand the window by moving `end` one character at a time.
     * - If a duplicate character is found (`s.charAt(end)` is already in the set),
     *   we shrink the window from the start by removing characters until the duplicate is removed.
     * - After each valid window update, we update the result with the length of the current window.
     *
     * This ensures we always have a substring without repeating characters.
     *
     * Example:
     * Input: "abcabcbb"
     * Output: 3  --> "abc" is the longest substring without repeating characters
     *
     * Time Complexity: O(n)
     * - Each character is visited at most twice: once by `end`, once by `start`.
     *
     * Space Complexity: O(min(n, m))
     * - `n` is the length of the string.
     * - `m` is the size of the character set (e.g., 26 for lowercase, 128 for ASCII).
     * - In worst case, all characters are unique and stored in the HashSet.
     */

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0, result = 0;

        for (int end = 0; end < s.length(); end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}

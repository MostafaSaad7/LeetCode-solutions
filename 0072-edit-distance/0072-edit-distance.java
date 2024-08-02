import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> memo = new HashMap<>();
        return findMinDistance(word1, word2, word1.length(), word2.length(), memo);
    }

    private int findMinDistance(String word1, String word2, int len1, int len2, Map<String, Integer> memo) {
        // If word1 is empty, we need len2 insertions to convert it to word2
        if (len1 == 0) return len2;
        // If word2 is empty, we need len1 deletions to convert word1 to it
        if (len2 == 0) return len1;

        // Create a unique key for the current subproblem
        String key = len1 + "," + len2;

        // If this subproblem has already been solved, return the cached result
        if (memo.containsKey(key)) return memo.get(key);

        // If the current characters match, no additional cost
        if (word1.charAt(len1 - 1) == word2.charAt(len2 - 1)) {
            memo.put(key, findMinDistance(word1, word2, len1 - 1, len2 - 1, memo));
        } else {
            // Calculate the cost for the three possible operations
            int insertCost = findMinDistance(word1, word2, len1, len2 - 1, memo);
            int deleteCost = findMinDistance(word1, word2, len1 - 1, len2, memo);
            int replaceCost = findMinDistance(word1, word2, len1 - 1, len2 - 1, memo);
            
            // The result for this subproblem is 1 + the minimum of the three operations
            memo.put(key, 1 + Math.min(insertCost, Math.min(deleteCost, replaceCost)));
        }

        return memo.get(key);
    }
}

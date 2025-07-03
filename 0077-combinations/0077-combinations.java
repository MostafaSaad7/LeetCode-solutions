
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        // Start backtracking from number 1
        backtrack(n, k, 1, current, result);
        
        return result;
    }
    
    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: we've selected k numbers
        if (current.size() == k) {
            result.add(new ArrayList<>(current)); // Make a copy!
            return;
        }
        
        // Try all numbers from 'start' to n
        for (int i = start; i <= n; i++) {
            // Choose: add current number
            current.add(i);
            
            // Recurse: try to complete the combination
            backtrack(n, k, i + 1, current, result);
            
            // Backtrack: remove the number we just added
            current.remove(current.size() - 1);
        }
    }
}
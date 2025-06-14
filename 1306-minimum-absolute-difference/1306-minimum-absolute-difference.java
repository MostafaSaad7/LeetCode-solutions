import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Finds all pairs of elements with the minimum absolute difference.
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(n) for storing the result.
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array — O(n log n) time
        Arrays.sort(arr);

        int minSoFar = Integer.MAX_VALUE;

        // Step 2: Find the minimum absolute difference — O(n) time
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minSoFar) {
                // Found smaller diff, clear result list and update minSoFar
                result.clear(); // O(1) amortized
                result.add(Arrays.asList(arr[i - 1], arr[i])); // O(1)
                minSoFar = diff;
            } else if (diff == minSoFar) {
                // Same as current minimum, add the pair
                result.add(Arrays.asList(arr[i - 1], arr[i])); // O(1)
            }
        }

        // Total Time Complexity: O(n log n)
        // Total Space Complexity: O(n) for the result list (in worst case, nearly n/2 pairs)
        return result;
    }
}

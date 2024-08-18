import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, Integer> freqMap = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentNums = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Initialize frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Start backtracking
        backtrack(nums.length);
        return result;
    }

    private void backtrack(int remaining) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currentNums));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > 0) {
                currentNums.add(num);
                freqMap.put(num, count - 1);

                // Recurse with one less number to place
                backtrack(remaining - 1);

                // Backtrack by undoing the last choice
                currentNums.remove(currentNums.size() - 1);
                freqMap.put(num, count);
            }
        }
    }
}

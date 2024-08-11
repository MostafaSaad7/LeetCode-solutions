import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentElem = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, 0, target, candidates);
        return result;
    }

    private void dfs(int idx, int currentSum, int target, int[] candidates) {
        if (currentSum == target) {
            result.add(new ArrayList<>(currentElem));
            return;
        }
        if (currentSum > target || idx == candidates.length) {
            return;
        }

        // Include the current candidate
        currentElem.add(candidates[idx]);
        dfs(idx, currentSum + candidates[idx], target, candidates);
        currentElem.remove(currentElem.size() - 1);

        // Exclude the current candidate and move to the next
        dfs(idx + 1, currentSum, target, candidates);
    }
}

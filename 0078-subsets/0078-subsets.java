import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return result;
    }

    private void dfs(int idx, int[] nums, List<Integer> current) {
        // Add a copy of the current list to the result
        result.add(new ArrayList<>(current));
        
        for (int i = idx; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);
            // Move to the next element in the array
            dfs(i + 1, nums, current);
            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }
}

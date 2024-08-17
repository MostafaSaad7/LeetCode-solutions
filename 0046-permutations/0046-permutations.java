import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> indicies = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> currentElements = new ArrayList<>();

        return backtrack(currentElements, nums);
    }

    private List<List<Integer>> backtrack( List<Integer> currentElements, int[] nums) {
        if (currentElements.size() == nums.length) {
            result.add(new ArrayList<>(currentElements));
            return result;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!indicies.contains(j)) {
                currentElements.add(nums[j]);
                indicies.add(j);
                backtrack(currentElements, nums);
                indicies.remove(j);
                currentElements.remove(currentElements.size() - 1);
            }
        }

        return result;

    }


}
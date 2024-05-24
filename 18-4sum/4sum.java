import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array to handle duplicates and use two-pointer approach
        kSum(4, 0, (long)target, nums, new ArrayList<>());
        return res;
    }

    void kSum(int k, int start, long target, int[] nums, List<Integer> currentElements) {
        if (k == 2) {
            int l = start;
            int r = nums.length - 1;
            while (l < r) {
                long total = (long) nums[l] + nums[r];
                if (total < target) {
                    l++;
                } else if (total > target) {
                    r--;
                } else {
                    List<Integer> temp =  new ArrayList<>();
                    temp.add(nums[l]); // Add the left number to the combination.
                    temp.add(nums[r]); // Add the right number to the combination.
                    temp.addAll(currentElements);
                    res.add(new ArrayList<>(temp)); // Store the valid quadruplet in the result list.
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++; // Skip duplicates on the left.
                    }
                }
            }
        } else {
            for (int i = start; i < nums.length - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates
                currentElements.add(nums[i]);
                kSum(k - 1, i + 1, target - nums[i], nums, currentElements);
                currentElements.remove(currentElements.size() - 1); // Remove last element
            }
        }
    }
}

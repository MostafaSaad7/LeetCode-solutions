import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = -1, right = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                if (left == -1) left = i;
                right = i;
            }
        }

        return (left == -1) ? 0 : right - left + 1;
    }
}

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = 0, right = nums.length - 1;

        while (left < nums.length && nums[left] == sorted[left]) {
            left++;
        }

        while (right > left && nums[right] == sorted[right]) {
            right--;
        }

        return right - left + 1;
    }
}

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length==0)
            return 0;
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            }else {
                count = 1;
            }

        }

        return maxCount;
    }
}
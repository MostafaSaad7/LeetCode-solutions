import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        if (nums.length == 0)
            return 0;
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {

            if (!hashSet.contains(nums[i] - 1)) {
                int currentNum = nums[i];
                int currentCount = 1;
                // Count consecutive numbers starting from num
                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }

                maxCount = Math.max(maxCount, currentCount);
            }


        }
        return maxCount;
    }
}
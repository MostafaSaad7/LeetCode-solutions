import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0; // Return 0 for an empty array
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for (int num : nums) {
            // Start of a sequence if num - 1 is not in the set
            if (!set.contains(num - 1)) {
                int currentCount = 1;
                int currentNum = num;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }

                // Update the maximum length
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }
}

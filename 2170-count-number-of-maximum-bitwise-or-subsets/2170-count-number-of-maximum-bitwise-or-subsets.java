import java.util.Arrays;

class Solution {
    public int countMaxOrSubsets(int[] nums) {

        int maxOrRes = 0;
        for (int num : nums) {
            maxOrRes |= num;
        }

        int count = 0;
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets

        for (int mask = 0; mask < totalSubsets; mask++) {

            int currentOr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }

            if (currentOr == maxOrRes) {
                count++;
            }


        }

        return count;
    }
}
class Solution {
    public int maximumDifference(int[] nums) {
        int maxDef = -1;

        for (int times = 1; times < nums.length; times++) {
            for (int idx = times - 1; idx >= 0; idx--) {
                if (nums[times] > nums[idx]) {
                    int diff = nums[times] - nums[idx];
                    maxDef = Math.max(diff, maxDef);
                }
            }
        }

        return maxDef;
    }
}
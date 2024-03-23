class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int sumMin = nums[0];
        int minSumValue = nums[0];
        int sumMax = nums[0];
        int maxSumValue = nums[0];
        int fullArrSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumMin = Math.min(nums[i], sumMin + nums[i]);
            minSumValue = Math.min(sumMin, minSumValue);

            sumMax = Math.max(nums[i], sumMax + nums[i]);
            maxSumValue = Math.max(sumMax, maxSumValue);

            fullArrSum += nums[i];
        }

        if (fullArrSum == minSumValue) return maxSumValue; // -ve values for the whole array
        return Math.max(maxSumValue, fullArrSum - minSumValue);
    }
}
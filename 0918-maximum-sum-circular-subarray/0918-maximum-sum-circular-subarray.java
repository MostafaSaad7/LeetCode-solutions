import java.util.Arrays;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxSum = maxSum(nums);
        int minSum = minSum(nums);
        int fullArrSum = Arrays.stream(nums).sum();

        if (fullArrSum==minSum)return maxSum; // -ve values for the whole array 
        return Math.max(maxSum,fullArrSum-minSum);
    }

    int minSum(int[] nums) {
        int sum = nums[0];
        int minSumValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(nums[i], sum + nums[i]);
            minSumValue = Math.min(sum, minSumValue);
        }

        return minSumValue;
    }

    int maxSum(int[] nums) {
        int sum = nums[0];
        int maxSumValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSumValue = Math.max(sum, maxSumValue);
        }

        return maxSumValue;
    }
}
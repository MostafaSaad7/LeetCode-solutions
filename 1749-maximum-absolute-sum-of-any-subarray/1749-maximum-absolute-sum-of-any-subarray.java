class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }      
        sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
            if (sum >= 0)
                sum = 0;
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));

    }
}
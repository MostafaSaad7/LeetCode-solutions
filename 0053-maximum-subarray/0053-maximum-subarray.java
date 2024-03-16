class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
                right++;
                left = right;
            } else {
                right++;
            }

        }

        return res;

    }
}

/*
    Input: nums = [ 3, 1, -6,L R 4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*
*
* */
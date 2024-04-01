class Solution {
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] , nums[i] + sum);
            res = Math.max(res, sum);

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
class Solution {
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
            if (sum < 0)
                sum = 0;
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
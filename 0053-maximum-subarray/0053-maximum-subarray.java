class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int result = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            result=Math.max(result,sum);
            if (sum<0)
                sum=0;

        }
return result;
    }
}
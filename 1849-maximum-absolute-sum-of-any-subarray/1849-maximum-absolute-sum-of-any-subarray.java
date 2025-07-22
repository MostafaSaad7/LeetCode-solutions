class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentPrefixSum=0;
        int minPrevPrefixSum=0;
        int maxPrevPrefixSum=0;
        int result =0;

        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum+=nums[i];
            result=Math.max(result,Math.max(Math.abs(currentPrefixSum-maxPrevPrefixSum),Math.abs(currentPrefixSum-minPrevPrefixSum)));
            maxPrevPrefixSum=Math.max(maxPrevPrefixSum,currentPrefixSum);
            minPrevPrefixSum=Math.min(minPrevPrefixSum,currentPrefixSum);
        }
        return result;
    }
}
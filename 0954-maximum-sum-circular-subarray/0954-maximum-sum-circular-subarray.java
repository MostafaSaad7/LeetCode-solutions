class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax=0;
        int globalMax=nums[0];
        int currMin=0;
        int globalMin=nums[0];
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            currMin=Math.min(nums[i],currMin+nums[i]);
            currMax=Math.max(nums[i],currMax+nums[i]);
            total+=nums[i];
            globalMax=Math.max(globalMax,currMax);
            globalMin=Math.min(globalMin,currMin);
        }
        if (globalMax<0)
            return globalMax;

        return Math.max(globalMax,total-globalMin);
    }
}
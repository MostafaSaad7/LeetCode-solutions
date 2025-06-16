class Solution {
    public int maximumDifference(int[] nums) {
        int maxDef = -1;
        int maxElem=nums[nums.length-1];
        for (int i = nums.length-2 ;i>=0 ; i--)
        {
            int substraction = maxElem-nums[i];
            if (substraction>0)
            {
                maxDef=Math.max(maxDef,substraction);
            }
            else
            {
                maxElem=nums[i];
            }
            
            
        }


        return maxDef;
    }
}
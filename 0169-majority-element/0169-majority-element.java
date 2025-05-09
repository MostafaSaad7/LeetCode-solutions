class Solution {
    public int majorityElement(int[] nums) {

        int majorElement=nums[0];
        int majorElementCount=1;

        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            if (number == majorElement)
            {
                majorElementCount++;
            }
            else if (--majorElementCount < 0)
            {
                majorElement=number;
                majorElementCount=1;
            }
        }
        return majorElement;
    }
}
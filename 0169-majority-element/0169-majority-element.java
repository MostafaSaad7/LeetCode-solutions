class Solution {
    public int majorityElement(int[] nums) {
        int maxElemCount=1;
        int element=nums[0];
        for(int i = 1 ; i < nums.length;i++)
        {   
            if(element == nums[i])
                maxElemCount++;
            else{
                maxElemCount--;
            }

            if(maxElemCount < 0 )
            {
                maxElemCount=1;
                element=nums[i];
            }


        }

        return element;
    }
}
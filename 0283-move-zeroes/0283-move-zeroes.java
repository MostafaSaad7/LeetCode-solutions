class Solution {
    public void moveZeroes(int[] nums) {
        int slowPointer = 0;
 
        for(int i = 0 ; i < nums.length;i++)
        {
            if(nums[i]!=0){
                int temp=nums[slowPointer];
                nums[slowPointer]=nums[i];
                nums[i]=temp;
                slowPointer++;
            }
        }

    }
}
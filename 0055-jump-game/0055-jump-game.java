class Solution {
    public boolean canJump(int[] nums) {
        int goal=nums.length-1;
        for (int pos = nums.length-1; pos >=0 ; pos--) {
            if (pos+nums[pos]>=goal)
                goal=pos;
        }

        return goal==0;
    }

}
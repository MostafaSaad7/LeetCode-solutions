class Solution {
    public boolean canJump(int[] nums) {
        int maxJump =0;
        for (int pos =0 ; pos < nums.length ; pos++) {
            if(pos > maxJump) return false;
            maxJump=Math.max(maxJump, nums[pos]+pos);
        }

        return true;
    }

}
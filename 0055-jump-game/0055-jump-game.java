class Solution {
    public boolean canJump(int[] nums) {
        return dp(nums, 0, new Boolean[nums.length]);
    }
    
    private boolean dp(int[] nums, int index, Boolean[] memo) {
        if (index == nums.length - 1)
            return true;
        if (index >= nums.length)
            return false;
        if (memo[index] != null)
            return memo[index];
        
        boolean result = false;
     
        for (int jump = 1; jump <= nums[index]; jump++) {
            int newIndex = index + jump;
            if (newIndex < nums.length) {
                result |= dp(nums, newIndex, memo);
                if (result) break; 
            }
        }
        
        memo[index] = result;
        return result;
    }
}
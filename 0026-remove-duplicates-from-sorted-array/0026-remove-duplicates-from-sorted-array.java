class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                curr = nums[i];
                nums[left]=curr;
                left++;
            }
        }

        return left;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0; // points to where the next non-val element should go

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i]; // overwrite the value at 'slow'
                slow++;
            }
        }

        return slow; // new length of array after removing val
    }
}

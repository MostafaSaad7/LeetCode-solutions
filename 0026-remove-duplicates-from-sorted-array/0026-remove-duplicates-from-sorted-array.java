class Solution {
    public int removeDuplicates(int[] nums) {

        int currentNum = -101;
        int nextPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentNum != nums[i]) {
                nums[nextPosition++] = nums[i];
                currentNum = nums[i];
            }
        }
        return nextPosition;
    }
}

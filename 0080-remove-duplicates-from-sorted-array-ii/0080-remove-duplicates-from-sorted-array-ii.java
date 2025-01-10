class Solution {
    public int removeDuplicates(int[] nums) {

        int currentNum = -101;
        int numCount = 0;
        int nextPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != currentNum) {
                currentNum = nums[i];
                numCount = 1;
                nums[nextPosition++] = currentNum;
            } else if (numCount == 1) {
                nums[nextPosition++] = currentNum;
                numCount++;
            }
        }
        return nextPosition;

    }

}






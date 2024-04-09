class Solution {
    public int removeElement(int[] nums, int val) {

        int nonEqVal = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val)
                swap(nums, nonEqVal++, i);
        }


        return nonEqVal;

    }


    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
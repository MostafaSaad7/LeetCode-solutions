class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]*nums[i];
        }
        int left = 0, right = nums.length-1;
        int[] res = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[left] < nums[right]) {
                res[i] = nums[right];
                right--;
            } else {
                res[i] = nums[left];
                left++;
            }
        }
        return res;
    }
}

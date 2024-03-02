class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length-1;
        while (left <= right) {
            int rightNum = Math.abs(nums[right]);
            int leftNum = Math.abs(nums[left]);

            res[i--] = (int) Math.pow(Math.max(leftNum, rightNum),2);

            if (leftNum <= rightNum)
                right--;
            else
                left++;
        }
        return res;
    }
}
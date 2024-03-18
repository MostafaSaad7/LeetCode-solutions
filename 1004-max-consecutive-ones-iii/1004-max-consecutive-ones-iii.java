class Solution {
    public int longestOnes(int[] nums, int k) {
        int longestOnesCount = 0;
        for (int start = 0; start < nums.length; start++) {
            int zerosCount = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zerosCount++;
                }
                if (zerosCount <= k)
                    longestOnesCount = Math.max(longestOnesCount, end - start + 1);
                else
                    break;
            }

        }
        return longestOnesCount;
    }
}
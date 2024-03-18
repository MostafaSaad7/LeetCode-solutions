class Solution {
    public int longestOnes(int[] nums, int k) {
        int longestOnesCount = 0;
        int numberOfZeros = 0;
        int start = 0;
        for (int end = start; end < nums.length; end++) {
            if (nums[end] == 0)
                numberOfZeros++;
            while (numberOfZeros > k) {
                if (nums[start] == 0)
                    numberOfZeros--;
                start++;

            }

            longestOnesCount = Math.max(longestOnesCount, end - start + 1);
        }
        return longestOnesCount;
    }
}
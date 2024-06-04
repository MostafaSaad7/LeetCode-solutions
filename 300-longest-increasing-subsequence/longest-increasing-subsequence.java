import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i > -1; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

            }


        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
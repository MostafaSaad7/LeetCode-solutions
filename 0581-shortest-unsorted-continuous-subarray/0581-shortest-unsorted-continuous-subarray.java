import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        int left = -1 ;
        int right = -1 ;
        for (int i = 0; i < nums.length; i++) {
            maxSoFar=Math.max(maxSoFar,nums[i]);
            if (maxSoFar> nums[i])
                right = i ;
        }

        if (right == -1 ) // Already sorted
             return 0;

        for (int i = nums.length-1; i >-1; i--) {
            minSoFar=Math.min(minSoFar,nums[i]);
            if (minSoFar <  nums[i])
                left = i ;
        }


        return right-left+1;
    }
}

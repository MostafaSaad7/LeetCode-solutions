import java.util.Arrays;

class Solution {
    public boolean canSortArray(int[] nums) {

        int segmentMaxNumber = nums[0];
        int segmentMinNumber = nums[0];
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxElemetinPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) {
                segmentMaxNumber = Math.max(segmentMaxNumber, nums[i]);
                segmentMinNumber = Math.min(segmentMinNumber, nums[i]);
            } else {
                // new segment
                if (maxElemetinPrevSegment > segmentMinNumber) // SC
                    return false;
                maxElemetinPrevSegment = segmentMaxNumber;
                numOfSetBits = Integer.bitCount(nums[i]);
                segmentMinNumber = segmentMaxNumber = nums[i];
            }

        }


        // handling the last segment of the array
        if (maxElemetinPrevSegment > segmentMinNumber)
            return false;


        return true;
    }
}
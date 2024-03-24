class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            int slowNumber = nums[slow];
            int fastNumber = nums[fast];
               if (fastNumber != 0) {
                nums[slow]=fastNumber;
                nums[fast]=slowNumber;
                slow++;
            }

            fast++;
        }

    }
}
/*
    Input: nums = [1,3,12,13,16,0,0,12,23]
                                s
                                  f

if not eq zero replace it with f

s and f
1- s at non zero then s =f
2- f at zero and s at non zero so s = f
3- f at zero and s at zero then do nothing
4- f at non zero and s at zero then swap and increase s by 1

    Output: [1,3,12,0,0]
*
*
*
* */
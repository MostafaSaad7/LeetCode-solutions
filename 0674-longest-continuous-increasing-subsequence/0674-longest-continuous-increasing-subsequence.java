class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxSequence = 1;
        int seqCount = 1 ;
        for (int i =1 ; i < nums.length;i++)
        {
            if (nums[i] > nums[i-1])
                seqCount++;
            else
            seqCount =1 ;

            maxSequence= Math.max(seqCount,maxSequence);
        }

        return maxSequence;
    }
}
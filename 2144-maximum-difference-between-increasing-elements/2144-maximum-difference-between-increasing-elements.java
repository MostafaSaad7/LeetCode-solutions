class Solution {
    public int maximumDifference(int[] nums) {
        int minNumberSoFar = Integer.MAX_VALUE;
        int result = -1 ;
        for (int num:nums) {
            if (num > minNumberSoFar)
            {
                result=Math.max(result,num-minNumberSoFar);
                
            }
            minNumberSoFar=Math.min(minNumberSoFar,num);
        }

        return result;
    }
}
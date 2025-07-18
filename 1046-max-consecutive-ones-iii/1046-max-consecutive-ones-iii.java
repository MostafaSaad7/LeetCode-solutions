class Solution {
    public int longestOnes(int[] nums, int k) {
        int result =0;
        int start = 0,zeros=0;
        for (int end=0; end<nums.length ; end++) {
            if (nums[end]==0)
                zeros+=1;
            while (zeros > k)
            {
                if (nums[start]==0)
                    zeros--;
                start++;
            }
        result=Math.max(result,end-start+1);

        }

        return result;
    }
}
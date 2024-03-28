class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int res = 0;
        int left = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (product >= k && left <=i) {
                product/=nums[left];
                left++;
            }

            int addedSubArrays = i-left+1;
            // because each time you add a new number
            // you are not only add one sub array, but it may be more than one sub array
            res+=addedSubArrays;
        }
        return res;
    }
}
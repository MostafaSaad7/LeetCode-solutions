class Solution {
    public int findMin(int[] nums) {

        int arrayLength = nums.length;
        if (arrayLength == 1 || nums[0] <= nums[arrayLength -1]) {
            return nums[0];
        }

        int left=0,right=arrayLength-1;
        while (left<=right)
        {
            int mid = left+(right-left)/2;

            if (nums[mid] <= nums[(mid + 1) % arrayLength] && nums[mid] <= nums[(mid - 1) % arrayLength]) {
                return nums[mid];
            } else if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right=mid-1;
            }

        }
        
        return -1;

    }
}
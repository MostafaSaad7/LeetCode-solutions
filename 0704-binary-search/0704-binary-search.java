class Solution {
    public int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length-1])
            return -1;
        int left = 0 ;
        int right = nums.length-1;
        int res =-1;
        while(left<=right)
        {
            int mid= (right+left)/2;
            if(nums[mid] == target)
            {
                res= mid;
                break;
            }

            else if (target > nums[mid])
                left=mid+1;
            else
                right = mid-1;
        }

        return res;

    }
}
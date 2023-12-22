class Solution {
    public int search(int[] nums, int target) {

        int arrayLenght = nums.length;
        int start = 0;
        int end = arrayLenght - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {

                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {
                if (target < nums[mid] || target > nums[end]) {
                    
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
     
        }
        return -1;
    }
}
import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int operations = 0;
        
        // Find all distinct values using binary search
        for (int i = 0; i < n; ) {
            int currentValue = nums[i];
            
            // Binary search to find the rightmost occurrence of currentValue
            int rightmost = findRightmost(nums, currentValue);
            
            // All elements after rightmost position need to be reduced
            // through this value level
            int elementsToReduce = n - rightmost - 1;
            operations += elementsToReduce;
            
            // Move to next distinct value
            i = rightmost + 1;
        }
        
        return operations;
    }
    
    private int findRightmost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;  // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
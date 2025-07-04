import java.util.Arrays;

/**
 * LeetCode 611. Valid Triangle Number
 * 
 * Given an integer array nums, return the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.
 * 
 * Approach: Sort + Binary Search with Optimization
 * 
 * Key Insight: For a sorted array, if we fix two sides a and b (where a <= b),
 * we only need to find how many elements c satisfy: b < c < a + b
 * This is because the triangle inequality a + b > c is the only constraint we need
 * to check (the other two inequalities a + c > b and b + c > a are automatically satisfied).
 * 
 * Time Complexity: O(n² log n)
 * - O(n log n) for sorting
 * - O(n²) for the nested loops
 * - O(log n) for each binary search
 * - Overall: O(n² log n)
 * 
 * Space Complexity: O(1) 
 * - Only using constant extra space (excluding the input array)
 * - Sorting is done in-place
 */
class Solution {
    
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        
        // Edge case: need at least 3 elements to form a triangle
        if (n < 3) return 0;
        
        // Sort the array to use triangle inequality optimization
        Arrays.sort(nums);
        
        int count = 0;
        
        // Fix the first two sides of the triangle
        // i represents the smallest side, j represents the middle side
        for (int i = 0; i < n - 2; i++) {
            // Skip zero values as they can't form valid triangles
            if (nums[i] == 0) continue;
            
            // Optimization: start binary search from k = i + 2
            // This avoids redundant searches as k advances
            int k = i + 2;
            
            for (int j = i + 1; j < n - 1; j++) {
                // Find the first index where nums[index] >= nums[i] + nums[j]
                // All elements before this index can form valid triangles
                int firstInvalid = binarySearchLowerBound(nums, k, nums[i] + nums[j]);
                
                // Count valid triangles: elements from index (j+1) to (firstInvalid-1)
                // Formula: (firstInvalid - 1) - (j + 1) + 1 = firstInvalid - j - 1
                count += firstInvalid - j - 1;
                
                // Key optimization: update k to avoid redundant binary searches
                // If firstInvalid was found at index x for current (i,j), then for
                // next iteration (i,j+1), we know elements before x are still valid
                // since nums[j+1] >= nums[j], so nums[i] + nums[j+1] >= nums[i] + nums[j]
                k = Math.max(k, firstInvalid);
            }
        }
        
        return count;
    }
    
    /**
     * Binary search to find the first index where nums[index] >= target
     * This is equivalent to finding the lower bound of target in the sorted array
     * 
     * @param nums   sorted array to search in
     * @param start  starting index for search (optimization)
     * @param target value to find lower bound for
     * @return       first index where nums[index] >= target, or nums.length if not found
     */
    private int binarySearchLowerBound(int[] nums, int start, int target) {
        int end = nums.length - 1;
        int result = nums.length;  // default to "not found" (beyond array)
        
        while (start <= end) {
            int mid = start + (end - start) / 2;  // avoid overflow
            
            if (nums[mid] < target) {
                // Current element is too small, search in right half
                start = mid + 1;
            } else {
                // Current element is >= target, this could be our answer
                // But search in left half to find the first such element
                result = mid;
                end = mid - 1;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
Input: nums = [2,2,3,4]

After sorting: [2,2,3,4]
Indices:        0 1 2 3

i=0, j=1: nums[0] + nums[1] = 2 + 2 = 4
  Binary search from k=2 for first >= 4
  Found at index 3 (nums[3] = 4)
  Valid triangles: elements from index 2 to 2 (just nums[2]=3)
  Count: 3 - 1 - 1 = 1 triangle: (2,2,3)

i=0, j=2: nums[0] + nums[2] = 2 + 3 = 5  
  Binary search from k=3 for first >= 5
  Not found (return 4)
  Valid triangles: elements from index 3 to 3 (just nums[3]=4)
  Count: 4 - 2 - 1 = 1 triangle: (2,3,4)

i=1, j=2: nums[1] + nums[2] = 2 + 3 = 5
  Binary search from k=3 for first >= 5
  Not found (return 4)  
  Valid triangles: elements from index 3 to 3 (just nums[3]=4)
  Count: 4 - 2 - 1 = 1 triangle: (2,3,4)

Total: 1 + 1 + 1 = 3 triangles

Time Complexity Analysis:
- Sorting: O(n log n)
- Outer loop: O(n)
- Inner loop: O(n) 
- Binary search: O(log n)
- Total: O(n² log n)

Space Complexity: O(1) extra space
*/
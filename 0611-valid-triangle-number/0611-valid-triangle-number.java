import java.util.Arrays;

/**
 * LeetCode 611. Valid Triangle Number
 * 
 * Given an integer array nums, return the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.
 * 
 * Approach: Sort + Two Pointer Technique
 * 
 * Key Insight: For three sides to form a valid triangle, they must satisfy:
 * a + b > c, a + c > b, b + c > a (triangle inequality)
 * 
 * After sorting (a ≤ b ≤ c), we only need to check: a + b > c
 * The other two inequalities are automatically satisfied since:
 * - a + c > b (because c ≥ b and a > 0)
 * - b + c > a (because b ≥ a and c > 0)
 * 
 * Strategy: Fix the largest side c, then use two pointers to find all valid pairs (a,b)
 * 
 * Time Complexity: O(n²)
 * - O(n log n) for sorting
 * - O(n²) for the main algorithm (each element is visited at most once by each pointer)
 * - Overall: O(n²) - optimal for this problem!
 * 
 * Space Complexity: O(1)
 * - Only using constant extra space
 * - Sorting is done in-place
 */
class Solution {
    
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        
        // Edge case: need at least 3 elements to form a triangle
        if (n < 3) return 0;
        
        // Sort array to enable two-pointer technique and triangle inequality optimization
        Arrays.sort(nums);
        
        int count = 0;
        
        // Fix the largest side at index k (rightmost element)
        // We iterate k from 2 to n-1, ensuring we have at least 2 elements before k
        for (int k = 2; k < n; k++) {
            // Use two pointers to find all valid pairs (i,j) where nums[i] + nums[j] > nums[k]
            int i = 0;      // Left pointer (smallest element)
            int j = k - 1;  // Right pointer (second largest element, just before k)
            
            // Two-pointer technique to count valid triangles
            while (i < j) {
                // Check if current pair (i,j) with fixed k forms a valid triangle
                if (nums[i] + nums[j] > nums[k]) {
                    // If nums[i] + nums[j] > nums[k], then triangle inequality is satisfied
                    // 
                    // Key insight: ALL pairs (i, i+1), (i, i+2), ..., (i, j) are valid!
                    // This is because:
                    // - Array is sorted, so nums[i+1] ≥ nums[i], nums[i+2] ≥ nums[i], etc.
                    // - If nums[i] + nums[j] > nums[k], then nums[i+x] + nums[j] > nums[k] for x ≥ 0
                    // - Therefore, we can count (j - i) triangles at once
                    count += j - i;
                    
                    // Move j leftward to try next set of pairs
                    // We decrease j because we've already counted all valid pairs with current j
                    j--;
                } else {
                    // nums[i] + nums[j] ≤ nums[k], triangle inequality not satisfied
                    // We need a larger sum, so increase the smaller element
                    // Since j is already at maximum possible (k-1), we increase i
                    i++;
                }
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
Input: nums = [2,2,3,4]

Step 1: Sort array
nums = [2,2,3,4]
indices: 0 1 2 3

Step 2: Fix largest side and use two pointers

k=2 (nums[k]=3): Find pairs where nums[i] + nums[j] > 3
├─ i=0, j=1: nums[0] + nums[1] = 2 + 2 = 4 > 3 ✓
│  All pairs (0,1) work → count += 1-0 = 1
│  Move j to 0 (j--)
├─ i=0, j=0: i >= j, exit loop
│  Subtotal: 1

k=3 (nums[k]=4): Find pairs where nums[i] + nums[j] > 4
├─ i=0, j=2: nums[0] + nums[2] = 2 + 3 = 5 > 4 ✓
│  All pairs (0,1), (0,2) work → count += 2-0 = 2
│  Move j to 1 (j--)
├─ i=0, j=1: nums[0] + nums[1] = 2 + 2 = 4 ≤ 4 ✗
│  Move i to 1 (i++)
├─ i=1, j=1: i >= j, exit loop
│  Subtotal: 2

Total: 1 + 2 = 3 triangles: (2,2,3), (2,3,4), (2,3,4)

Time Complexity Analysis:
- Sorting: O(n log n)
- Main loop: O(n) iterations for k
- Two-pointer inner loop: O(n) total across all iterations of k
  (Each element is visited at most once by pointer i and once by pointer j)
- Overall: O(n log n + n²) = O(n²)

Space Complexity: O(1) - only using constant extra variables

Why O(n²) is optimal:
- We need to examine all possible triangles, which is O(n³) combinations
- Two-pointer technique reduces this to O(n²) by efficiently counting multiple triangles at once
- This is the best possible time complexity for this problem
*/
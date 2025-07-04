/**
 * Problem: Find the smallest divisor such that the sum of division results ≤ threshold
 * 
 * Approach: Binary Search on Answer
 * - Search space: [1, max(nums)] (smallest to largest possible divisor)
 * - For each candidate divisor, calculate sum of ceiling divisions
 * - If sum ≤ threshold, try smaller divisor (search left)
 * - If sum > threshold, try larger divisor (search right)
 * 
 * Time Complexity: O(n * log(max(nums)))
 * - Binary search: O(log(max(nums))) iterations
 * - Each iteration: O(n) to calculate division sum
 * 
 * Space Complexity: O(1) - only using constant extra space
 */
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // Search space: [1, max(nums)]
        // Lower bound: 1 (smallest possible divisor)
        // Upper bound: max(nums) (largest meaningful divisor)
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        
        // Binary search for the smallest valid divisor
        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            // Check if current divisor produces sum ≤ threshold
            if (getDivisionSum(nums, mid) <= threshold) {
                // Current divisor works, try to find smaller one
                right = mid;
            } else {
                // Current divisor too small, need larger divisor
                left = mid + 1;
            }
        }
        
        return left; // left == right, the smallest valid divisor
    }
    
    /**
     * Calculate sum of ceiling divisions: sum(ceil(num/divisor)) for all nums
     * 
     * Ceiling division trick: ceil(a/b) = (a + b - 1) / b
     * Example: ceil(7/3) = ceil(2.33) = 3 = (7 + 3 - 1) / 3 = 9/3 = 3
     * 
     * @param nums array of numbers to divide
     * @param divisor the divisor to use
     * @return sum of ceiling divisions
     */
    private int getDivisionSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Ceiling division: ceil(num/divisor) = (num + divisor - 1) / divisor
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}
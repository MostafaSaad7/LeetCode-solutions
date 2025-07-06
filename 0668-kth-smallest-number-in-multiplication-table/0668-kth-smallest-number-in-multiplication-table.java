/**
 * Problem: 668. Kth Smallest Number in Multiplication Table
 * 
 * Approach: Binary Search on Answer + Mathematical Counting
 * 
 * Key Insight: Instead of generating all m×n numbers and sorting them (which would
 * require O(m×n×log(m×n)) time and O(m×n) space), we use binary search to find
 * the answer and mathematically count how many numbers are ≤ target.
 * 
 * Core Algorithm:
 * 1. Binary search on possible answer values [1, m×n]
 * 2. For each candidate answer, count numbers ≤ candidate in O(m) time
 * 3. Find the smallest number that has at least k numbers ≤ it
 * 
 * Mathematical Insight for Counting:
 * In row i of multiplication table, elements are: i×1, i×2, i×3, ..., i×n
 * To count elements ≤ target in row i:
 * - We need i×j ≤ target, so j ≤ target/i
 * - But j is also limited by column count n
 * - So count = min(floor(target/i), n)
 * 
 * Time Complexity: O(m × log(m×n))
 * - Binary search: O(log(m×n)) iterations
 * - Each counting operation: O(m) to check all rows
 * - Total: O(m × log(m×n))
 * 
 * Space Complexity: O(1)
 * - Only using constant extra space for variables
 * - No additional data structures needed
 * 
 * Why this is better than naive approach:
 * - Naive: O(m×n×log(m×n)) time, O(m×n) space
 * - This:  O(m×log(m×n)) time, O(1) space
 * - For m=n=30,000: Naive needs ~27 billion operations, this needs ~450,000
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        // Binary search bounds:
        // Lower bound: 1 (smallest possible value in multiplication table)
        // Upper bound: m×n (largest possible value: bottom-right corner)
        int left = 1;
        int right = m * n;
        int result = right; // Initialize to worst case
        
        // Binary search for the smallest number that is the kth smallest
        // Invariant: result contains a valid answer
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow
            
            // Check if 'mid' could be our kth smallest number
            // by counting how many numbers in the table are ≤ mid
            if (hasAtLeastKNumbers(m, n, k, mid)) {
                // If we have at least k numbers ≤ mid, then mid could be our answer
                // But we want the SMALLEST such number, so search left for better answer
                right = mid - 1;
                result = mid; // Update our best answer so far
            } else {
                // If we have fewer than k numbers ≤ mid, we need a larger number
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    /**
     * Count how many numbers in the m×n multiplication table are ≤ target
     * 
     * Algorithm: For each row i (1-indexed), count elements ≤ target
     * Row i contains: i×1, i×2, i×3, ..., i×n
     * We want: i×j ≤ target, so j ≤ target/i
     * But j is also constrained by: 1 ≤ j ≤ n
     * Therefore: count in row i = min(floor(target/i), n)
     * 
     * Time Complexity: O(m) - iterate through all m rows
     * Space Complexity: O(1) - only using counter variable
     * 
     * @param m number of rows in multiplication table
     * @param n number of columns in multiplication table  
     * @param k the rank we're looking for (not used in counting, but kept for clarity)
     * @param target the value we're counting against
     * @return true if there are at least k numbers ≤ target
     */
    private boolean hasAtLeastKNumbers(int m, int n, int k, int target) {
        int count = 0;
        
        // Check each row of the multiplication table
        for (int i = 1; i <= m; i++) {
            // In row i, elements are: i×1, i×2, i×3, ..., i×n
            // Count how many satisfy: i×j ≤ target
            // This means: j ≤ target/i, and j ≤ n
            int elementsInRowI = Math.min(target / i, n);
            count += elementsInRowI;
            
            // Early termination optimization: if we already have k numbers,
            // we can return true immediately
            if (count >= k) {
                return true;
            }
        }
        
        return count >= k;
    }
}

/*
 * Example Walkthrough:
 * m=3, n=3, k=5
 * 
 * Multiplication table:
 * 1  2  3
 * 2  4  6
 * 3  6  9
 * 
 * Sorted elements: [1, 2, 2, 3, 4, 6, 6, 9]
 * 5th smallest = 4
 * 
 * Binary search process:
 * left=1, right=9
 * 
 * Check mid=5: hasAtLeastKNumbers(3,3,5,5)
 * Row 1: min(5/1, 3) = min(5,3) = 3
 * Row 2: min(5/2, 3) = min(2,3) = 2  
 * Row 3: min(5/3, 3) = min(1,3) = 1
 * Total count = 6 ≥ 5 ✓, so right=4, result=5
 * 
 * Check mid=2: hasAtLeastKNumbers(3,3,5,2)
 * Row 1: min(2/1, 3) = 2
 * Row 2: min(2/2, 3) = 1
 * Row 3: min(2/3, 3) = 0
 * Total count = 3 < 5 ✗, so left=3
 * 
 * Check mid=4: hasAtLeastKNumbers(3,3,5,4)
 * Row 1: min(4/1, 3) = 3
 * Row 2: min(4/2, 3) = 2
 * Row 3: min(4/3, 3) = 1  
 * Total count = 6 ≥ 5 ✓, so right=3, result=4
 * 
 * Final answer: 4
 */
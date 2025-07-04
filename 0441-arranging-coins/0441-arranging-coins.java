/**
 * LeetCode 441. Arranging Coins
 * 
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you will build.
 * 
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: 
 * Row 1: *     (1 coin)
 * Row 2: **    (2 coins)  
 * Row 3: **    (2 coins left, but need 3 - incomplete)
 * Total complete rows: 2
 * 
 * Example 2:
 * Input: n = 8
 * Output: 3
 * Explanation:
 * Row 1: *      (1 coin)
 * Row 2: **     (2 coins)
 * Row 3: ***    (3 coins)
 * Row 4: **     (2 coins left, but need 4 - incomplete)
 * Total complete rows: 3
 * 
 * Approach: Binary Search
 * 
 * Key Insight: We want to find the largest k such that:
 * 1 + 2 + 3 + ... + k ≤ n
 * 
 * Using the arithmetic series formula: k * (k + 1) / 2 ≤ n
 * 
 * We can use binary search to efficiently find this maximum k.
 * 
 * Time Complexity: O(log n)
 * - Binary search reduces the search space by half each iteration
 * - Maximum iterations: log₂(n)
 * 
 * Space Complexity: O(1)
 * - Only using constant extra space for variables
 */

class Solution {
    
    public int arrangeCoins(int n) {
        // Edge case: no coins means no complete rows
        if (n <= 0) return 0;
        
        // Binary search bounds
        int left = 1;      // Minimum: at least 1 complete row with 1+ coins
        int right = n;     // Maximum: worst case is 1 coin per row (n rows)
        int result = 0;    // Store the answer (number of complete rows)
        
        // Binary search to find the maximum number of complete rows
        while (left <= right) {
            // Calculate middle point, avoiding integer overflow
            int mid = left + (right - left) / 2;
            
            // Calculate total coins needed for 'mid' complete rows
            // Formula: 1 + 2 + 3 + ... + mid = mid * (mid + 1) / 2
            // Use long to prevent integer overflow for large values
            long coinsNeeded = (long) mid * (mid + 1) / 2;
            
            // Check if we can build 'mid' complete rows with available coins
            if (coinsNeeded <= n) {
                // We can build 'mid' complete rows
                result = mid;           // Update our best answer so far
                left = mid + 1;         // Try to build more rows (search right half)
            } else {
                // We need too many coins for 'mid' rows
                right = mid - 1;        // Try fewer rows (search left half)
            }
        }
        
        return result;
    }
    
    // Alternative implementation with explicit overflow checking
    public int arrangeCoinsAlternative(int n) {
        if (n <= 0) return 0;
        
        int left = 1, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canBuildCompleteRows(mid, n)) {
                left = mid + 1;     // Try more rows
            } else {
                right = mid - 1;    // Try fewer rows
            }
        }
        
        // At the end, 'right' will be the largest valid number of complete rows
        return right;
    }
    
    /**
     * Helper method to check if we can build 'rows' complete rows with 'n' coins
     * Uses careful arithmetic to avoid integer overflow
     */
    private boolean canBuildCompleteRows(int rows, int n) {
        // Calculate coins needed: rows * (rows + 1) / 2
        // Use long arithmetic to prevent overflow
        long coinsNeeded = (long) rows * (rows + 1) / 2;
        return coinsNeeded <= n;
    }
    
    // Bonus: Mathematical solution in O(1) time
    public int arrangeCoinsOptimal(int n) {
        /*
         * Mathematical approach: Solve the quadratic equation
         * k * (k + 1) / 2 = n
         * k² + k - 2n = 0
         * 
         * Using quadratic formula: k = (-1 + √(1 + 8n)) / 2
         * We take the floor of this value to get the largest integer k
         */
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}

/*
\U0001f3af ALGORITHM WALKTHROUGH:

Example: n = 8

Initial: left = 1, right = 8, result = 0

Iteration 1:
├─ mid = 1 + (8-1)/2 = 4
├─ coinsNeeded = 4 * 5 / 2 = 10
├─ 10 <= 8? No
└─ right = 4 - 1 = 3

Iteration 2:
├─ mid = 1 + (3-1)/2 = 2  
├─ coinsNeeded = 2 * 3 / 2 = 3
├─ 3 <= 8? Yes
├─ result = 2
└─ left = 2 + 1 = 3

Iteration 3:
├─ mid = 3 + (3-3)/2 = 3
├─ coinsNeeded = 3 * 4 / 2 = 6  
├─ 6 <= 8? Yes
├─ result = 3
└─ left = 3 + 1 = 4

Iteration 4:
├─ left = 4, right = 3
└─ left > right, exit loop

Result: 3 complete rows

Verification:
- Row 1: 1 coin  (total: 1)
- Row 2: 2 coins (total: 3) 
- Row 3: 3 coins (total: 6)
- Row 4: would need 4 coins (total: 10 > 8) ❌

Answer: 3 ✅

\U0001f680 KEY INSIGHTS:

1. Binary Search Target: Find maximum k where sum ≤ n
2. Overflow Prevention: Use long for arithmetic
3. Search Space: [1, n] covers all possible answers
4. Termination: When left > right, right holds the answer

\U0001f4a1 COMPLEXITY ANALYSIS:

Time: O(log n)
- Each iteration eliminates half the search space
- Maximum iterations: ⌈log₂(n)⌉

Space: O(1)  
- Only using constant extra variables
- No recursion or additional data structures

This is the optimal solution for the constraints!
*/
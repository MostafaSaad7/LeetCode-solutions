/**
 * Problem: Minimum Number of Days to Make m Bouquets
 * 
 * Strategy: Binary Search on Answer
 * Key Insight: If we can make m bouquets on day X, we can definitely make them 
 * on any day after X (monotonic property). This makes binary search perfect.
 * 
 * Time Complexity: O(n * log(max - min))
 * - Binary search: O(log(max - min)) where max-min is the range of bloom days
 * - Each validation: O(n) to scan through all flowers
 * 
 * Space Complexity: O(1) - only using constant extra space
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Critical Edge Case: Impossible Scenario
        // If we need more flowers than available, no amount of waiting helps
        // Example: need 3 bouquets of 5 flowers = 15 flowers, but only have 10
        if ((long)m * k > bloomDay.length) return -1;
        
        // Smart Search Bounds: Find actual min and max bloom days
        // Why not use [1, Integer.MAX_VALUE]? Because we never need to wait
        // longer than the latest flower's bloom day!
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (var day : bloomDay) {
            min = Math.min(day, min);  // Earliest any flower blooms
            max = Math.max(day, max);  // Latest any flower blooms
        }
        
        // Binary Search Setup
        int left = min;     // Earliest meaningful day to check
        int right = max;    // Latest meaningful day to check
        int result = max;   // Worst case: wait until all flowers bloom
        
        // Binary Search: Find minimum day that allows m bouquets
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow
            
            // Check if we can make m bouquets by day 'mid'
            if (possible(bloomDay, m, k, mid)) {
                // Success! But can we do better? Try earlier days
                right = mid - 1;
                result = mid;  // Update our best answer so far
            } else {
                // Not enough bouquets yet, need to wait longer
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    /**
     * Helper Function: Can we make m bouquets by the given day?
     * 
     * Algorithm: Scan left to right, counting consecutive bloomed flowers
     * - Every k consecutive flowers = 1 bouquet
     * - Reset counter when we hit a non-bloomed flower
     * - Stop early if we've already found m bouquets (optimization!)
     * 
     * Example: bloomDay=[1,10,3,10,2], day=3, k=2
     * Bloomed: [T,F,T,F,T] (positions 0,2,4)
     * No consecutive pairs of length 2, so 0 bouquets possible
     */
    boolean possible(int[] bloomDay, int m, int k, int day) {
        int consecutiveBloomsCounter = 0;  // Track consecutive bloomed flowers
        
        // Scan through garden, count consecutive bloomed flowers
        // Optimization: stop early if we've found enough bouquets (m==0)
        for (int i = 0; i < bloomDay.length && m != 0; i++) {
            
            if (bloomDay[i] <= day) {
                // This flower has bloomed by our target day
                consecutiveBloomsCounter++;
                
                // Do we have enough consecutive flowers for a bouquet?
                if (consecutiveBloomsCounter == k) {
                    // Hooray! We made a bouquet
                    consecutiveBloomsCounter = 0;  // Reset for next bouquet
                    m--;  // One less bouquet needed
                }
            } else {
                // This flower hasn't bloomed yet - breaks our consecutive chain
                // Example: [bloomed, bloomed, NOT_BLOOMED, bloomed]
                //          We can't skip the non-bloomed flower to continue counting
                consecutiveBloomsCounter = 0;  // Reset counter
            }
        }
        
        // Success condition: we found all m bouquets we needed
        // If m > 0, we didn't find enough bouquets
        return m == 0;
    }
}
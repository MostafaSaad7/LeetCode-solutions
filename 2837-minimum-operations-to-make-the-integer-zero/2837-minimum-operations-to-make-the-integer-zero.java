/**
 * Problem: Make the Integer Zero
 *
 * We want the smallest integer k such that:
 *
 *      num1 - k * num2 = sum of exactly k powers of 2
 *
 * -------------------------------------------------------
 * Step 1. Rearrange equation:
 *      target = num1 - k * num2
 *
 * Step 2. Interpret "sum of exactly k powers of 2":
 *      Example: target = 13
 *      - Possible with k=2: 8 + 5 (not valid since 5 is not a power of 2)
 *      - Possible with k=3: 8 + 4 + 1 (valid)
 *
 * Step 3. Bounds on k:
 *   - The minimum number of powers of 2 required is the
 *     number of 1s in the binary representation of target
 *     (called popcount).
 *       Example: target = 13 (binary 1101) → popcount = 3.
 *
 *   - The maximum number of powers of 2 possible is target
 *     itself (using all ones: 1+1+...+1).
 *
 *   Therefore, valid k must satisfy:
 *
 *      popcount(target) <= k <= target
 *
 * Step 4. Extra constraint:
 *   - Since each power of 2 is >= 1, we must also have:
 *
 *      target >= k
 *
 * -------------------------------------------------------
 * Algorithm:
 *   - Iterate k from 1 to 60 (safe bound for 64-bit numbers).
 *   - Compute target = num1 - k * num2.
 *   - If target < k, break (impossible from this point onward).
 *   - If popcount(target) <= k <= target → return k.
 *   - If no k works, return -1.
 *
 * -------------------------------------------------------
 * Time Complexity:
 *   O(60) = O(1), since we only try up to 60 values of k.
 *   Each step uses bitCount, which is O(1).
 *
 * Space Complexity:
 *   O(1), constant extra space.
 */
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) { // check each possible k
            long target = (long) num1 - (long) k * num2;

            // If target < k → impossible
            // Minimum possible sum of k powers of 2 is k*1 = k
            if (target < k) break;

            // Check if k is within the valid range:
            // popcount(target) <= k <= target
            if (Long.bitCount(target) <= k && k <= target) {
                return k; // Found smallest valid k
            }
        }
        return -1; // No valid k found
    }
}

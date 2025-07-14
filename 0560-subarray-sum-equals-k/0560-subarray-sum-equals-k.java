import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;

        // Map to store (prefixSum, frequency)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important base case: sum 0 has occurred once

        for (int num : nums) {
            prefixSum += num;

            // Check if there exists a prefix sum that satisfies: prefixSum - target = k
            int target = prefixSum - k;

            // If such prefix sum exists, add its frequency to count
            count += map.getOrDefault(target, 0);

            // Update the map with the current prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

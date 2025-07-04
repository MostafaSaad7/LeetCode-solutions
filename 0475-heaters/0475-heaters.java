class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Step 1: Sort heaters to enable binary search
        // This allows us to efficiently find the closest heater for each house
        Arrays.sort(heaters);
        
        int maxRadius = 0; // Track the maximum radius needed
        
        // Step 2: For each house, find the minimum distance to any heater
        for (int house : houses) {
            int closestDistance = findClosestHeaterDistance(house, heaters);
            // Step 3: Update our answer with the worst-case house
            maxRadius = Math.max(maxRadius, closestDistance);
        }
        
        return maxRadius;
    }
    
    /**
     * Find the distance from a house to its closest heater
     * Uses binary search for O(log n) efficiency
     */
    private int findClosestHeaterDistance(int house, int[] heaters) {
        // Use binary search to find where this house would be inserted
        int insertPosition = Arrays.binarySearch(heaters, house);
        
        // If exact match found, distance is 0
        if (insertPosition >= 0) {
            return 0;
        }
        
        // Convert insertion point to actual index
        // binarySearch returns -(insertion_point + 1) when not found
        insertPosition = -(insertPosition + 1);
        
        int minDistance = Integer.MAX_VALUE;
        
        // Check heater to the left (if exists)
        if (insertPosition > 0) {
            int leftHeater = heaters[insertPosition - 1];
            minDistance = Math.min(minDistance, house - leftHeater);
        }
        
        // Check heater to the right (if exists)  
        if (insertPosition < heaters.length) {
            int rightHeater = heaters[insertPosition];
            minDistance = Math.min(minDistance, rightHeater - house);
        }
        
        return minDistance;
    }
}
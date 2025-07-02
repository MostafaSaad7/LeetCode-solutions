import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Store each interval's start point along with its original index
        // Format: [start, originalIndex]
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // Sort intervals by start value
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        // For each interval, find the "right interval"
        for (int i = 0; i < n; i++) {
            int targetEnd = intervals[i][1]; // We want to find start >= end
            result[i] = binarySearch(starts, targetEnd);
        }

        return result;
    }

    // Binary search to find the smallest interval whose start >= target
    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        int res = -1; // Default if no interval found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the mid start is >= target, it's a candidate
            if (starts[mid][0] >= target) {
                res = starts[mid][1]; // Save original index
                right = mid - 1; // Try to find a smaller valid interval
            } else {
                left = mid + 1; // Go right to find larger start values
            }
        }

        return res;
    }
}

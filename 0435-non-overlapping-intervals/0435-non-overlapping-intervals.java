import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: if there are no intervals, return 0
        if (intervals.length == 0) return 0;

        // Step 1: Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Initialize variables
        int count = 0;
        int prevEnd = intervals[0][1];

        // Step 3: Iterate through the intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlapping interval, increment the count
                count++;
            } else {
                // Non-overlapping interval, update prevEnd
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}

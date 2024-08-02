import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int index = 0;

        // Add all intervals that end before the new interval starts
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }

        // Merge overlapping intervals with the new interval
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = min(newInterval[0], intervals[index][0]);
            newInterval[1] = max(newInterval[1], intervals[index][1]);
            index++;
        }
        result.add(newInterval);

        // Add remaining intervals that start after the new interval ends
        while (index < intervals.length) {
            result.add(intervals[index]);
            index++;
        }

        // Convert the result list back to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}

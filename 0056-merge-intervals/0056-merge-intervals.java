import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0])); // Sorting based on start times
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (isThereAnyOverlapping(currentInterval, intervals[i])) {
                // Merge the intervals
                currentInterval = new int[]{Math.min(currentInterval[0], intervals[i][0]), Math.max(currentInterval[1], intervals[i][1])};
            } else {
                // Add the current interval to result and move to the next
                res.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        res.add(currentInterval);

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }

    private boolean isThereAnyOverlapping(int[] currentInterval, int[] interval) {
        return currentInterval[1] >= interval[0];
    }
}

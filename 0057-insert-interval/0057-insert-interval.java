import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int counter = 0;
        for (var interval : intervals) {
            if (max(interval[0], newInterval[0]) <= min(interval[1], newInterval[1])) // any overlapping
            {
                newInterval[0] = min(interval[0], newInterval[0]);
                newInterval[1] = max(interval[1], newInterval[1]);
            } else if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else {
                break;
            }
            counter++;
        }
        result.add(newInterval);

        for (int i = counter; i < intervals.length; i++) {
            result.add(intervals[i]);
        }


        return result.toArray(new int[result.size()][]);
    }


}
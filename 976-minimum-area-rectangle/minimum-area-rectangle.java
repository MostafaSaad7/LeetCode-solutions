import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int minAreaRect(int[][] points) {
        if (points.length < 4) return 0;
        int minArea = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<Integer>> coordinates = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            coordinates.putIfAbsent(points[i][0], new HashSet<>());
            coordinates.get(points[i][0]).add(points[i][1]);
        }
        for (int i = 0; i < points.length; i++) {
            int p1x = points[i][0];
            int p1y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {

                int p2x = points[j][0];
                int p2y = points[j][1];

                if (p1x == p2x || p1y == p2y)
                    continue;

                if (!coordinates.get(p1x).contains(p2y) || !coordinates.get(p2x).contains(p1y))
                    continue;

                minArea = Math.min(minArea, (Math.abs(p1x - p2x) * Math.abs(p1y - p2y)));
            }
        }

        return minArea == Integer.MAX_VALUE?0:minArea;
    }
}
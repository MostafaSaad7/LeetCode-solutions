import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;

        // Find the max in one pass
        for (int c : candies) {
            if (c > max) max = c;
        }

        // Check each kid
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;
    }
}

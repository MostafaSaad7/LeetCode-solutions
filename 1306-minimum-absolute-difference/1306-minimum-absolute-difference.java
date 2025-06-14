import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minSoFar = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minSoFar) {
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
                minSoFar = diff;
            } else if (diff == minSoFar) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}
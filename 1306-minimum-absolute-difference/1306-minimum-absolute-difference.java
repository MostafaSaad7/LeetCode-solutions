import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int minSoFar= Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            minSoFar=Math.min(minSoFar,arr[i]-arr[i-1]);
        }

        for (int i = 1; i < arr.length; i++) {
           if ((arr[i]-arr[i-1])==minSoFar)
               result.add(Arrays.asList(arr[i-1],arr[i]));
        }

        return result;
    }
}
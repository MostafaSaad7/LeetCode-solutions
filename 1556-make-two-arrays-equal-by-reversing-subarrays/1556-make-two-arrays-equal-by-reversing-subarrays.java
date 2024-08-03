import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Create a map to count the frequency of each element in target
        Map<Integer, Integer> targetCount = new HashMap<>();
        for (int num : target) {
            targetCount.put(num, targetCount.getOrDefault(num, 0) + 1);
        }

        // Create a map to count the frequency of each element in arr
        Map<Integer, Integer> arrCount = new HashMap<>();
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }

        // Compare the frequency maps of target and arr
        return targetCount.equals(arrCount);
    }
}

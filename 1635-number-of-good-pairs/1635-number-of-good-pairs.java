import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); // number ---> number counts
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : map.keySet()) {
            int n = map.get(num);
            count += n * (n - 1) / 2; // n choose 2
        }
        
        return count;
    }
}
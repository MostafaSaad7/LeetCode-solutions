import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private final int MOD = 1_000_000_007;

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> numberComMap = new HashMap<>();
        Arrays.sort(arr);

        for (int root : arr) {
            long ways = 1; // Every element can be a single-node tree.
            for (int node : arr) {
                if (node >= root) break; // No need to check further as arr is sorted.
                if (root % node == 0 && numberComMap.containsKey(root / node)) {
                    ways = (ways + numberComMap.get(node) * numberComMap.get(root / node)) % MOD;
                }
            }
            numberComMap.put(root, ways);
        }

        long result = 0;
        for (long count : numberComMap.values()) {
            result = (result + count) % MOD;
        }
        return (int) result;
    }
}

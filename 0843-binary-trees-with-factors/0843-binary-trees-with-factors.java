import java.util.*;

class Solution {
    long[] dp;
    Map<Integer, Integer> index;
    int[] arr;
    long MOD = 1000000007;
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        this.arr = arr;
        dp = new long[arr.length];
        Arrays.fill(dp, -1);
        
        // Map to quickly find if a number exists and its index
        index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }
        
        long result = 0;
        
        // Sum up trees possible with each number as root
        for (int i = 0; i < arr.length; i++) {
            result = (result + solve(i)) % MOD;
        }
        
        return (int) result;
    }
    
    private long solve(int i) {
        // Returns: number of trees with arr[i] as root
        
        if (dp[i] != -1) {
            return dp[i];
        }
        
        // Base: this number alone forms 1 tree
        long ways = 1;
        
        // Try all possible factor pairs (left_child, right_child)
        // where left_child * right_child = arr[i]
        for (int j = 0; j < arr.length; j++) {
            // Check if arr[i] is divisible by arr[j]
            if (arr[i] % arr[j] == 0) {
                int other = arr[i] / arr[j];
                
                // Check if the other factor exists
                if (index.containsKey(other)) {
                    int k = index.get(other);
                    
                    // arr[j] can be left child, arr[k] can be right child
                    // Number of trees with this pair = solve(j) * solve(k)
                    ways = (ways + solve(j) * solve(k)) % MOD;
                }
            }
        }
        
        dp[i] = ways;
        return dp[i];
    }
}
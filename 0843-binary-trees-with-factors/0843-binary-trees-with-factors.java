import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long MOD = 1000000007;
        
        long[] dp = new long[arr.length];

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }
        
        long result = 0;
        

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;  
            for (int j = 0; j < i; j++) {  
                if (arr[i] % arr[j] == 0) {
                    int other = arr[i] / arr[j];  
                    if (index.containsKey(other)) {
                        int k = index.get(other);

                        dp[i] = (dp[i] + dp[j] * dp[k]) % MOD;
                    }
                }
            }
            
            result = (result + dp[i]) % MOD;
        }
        
        return (int) result;
    }
}
import java.util.Arrays;

class Solution {

    int[] cache;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        cache = new int[arr.length];
        Arrays.fill(cache, -1);
        return dfs(arr, 0, k);
    }

    int dfs(int[] arr, int startIndex, int k) {
        if (startIndex >= arr.length) return 0;
        if (cache[startIndex] != -1) return cache[startIndex]; // Corrected to return cache value

        int currentMax = 0;
        int maxSum = 0; // Added to track the maximum sum
        for (int splitIndex = startIndex; splitIndex < Math.min(arr.length, startIndex + k); splitIndex++) {
            currentMax = Math.max(currentMax, arr[splitIndex]);
            int winSize = splitIndex - startIndex + 1;
            int currentSum = currentMax * winSize;
            maxSum = Math.max(maxSum, currentSum + dfs(arr, splitIndex + 1, k)); // Updated to track the maximum sum
        }

        cache[startIndex] = maxSum; // store the max sum at the startIndex
        return maxSum; // return the max sum
    }
}

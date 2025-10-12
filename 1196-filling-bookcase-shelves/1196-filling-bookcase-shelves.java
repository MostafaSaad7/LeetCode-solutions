import java.util.Arrays;

class Solution {
    int[] dp;
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length];
        Arrays.fill(dp, -1);
        return solve(0, books, shelfWidth);
    }
    
    int solve(int idx, int[][] books, int shelfWidth) {
        // Base case: no more books
        if (idx >= books.length) {
            return 0;
        }
        
        // Check memo
        if (dp[idx] != -1) {
            return dp[idx];
        }
        
        int currentWidth = 0;
        int shelfHeight = 0;
        int minTotalHeight = Integer.MAX_VALUE;
        
        // Try placing books[idx...i] on the same shelf
        for (int i = idx; i < books.length; i++) {
            currentWidth += books[i][0]; 
            
            // Check if books fit on shelf
            if (currentWidth > shelfWidth) {
                break; 
            }
            
            // Update shelf height
            shelfHeight = Math.max(shelfHeight, books[i][1]);
            
            // Calculate total height for this configuration
            int totalHeight = shelfHeight + solve(i + 1, books, shelfWidth);  
            
            // Track minimum
            minTotalHeight = Math.min(minTotalHeight, totalHeight);
        }
        
        dp[idx] = minTotalHeight;
        return dp[idx];
    }
}
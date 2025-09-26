import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> dp;
    
    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        return solve(prices, 0, "cooldown");
    }
    
    int solve(int[] prices, int idx, String prevAction) {
        if (idx >= prices.length) return 0;
        
        String key = idx + "-" + prevAction;
        if (dp.containsKey(key)) return dp.get(key);
        
        int result = 0;
        
        if (prevAction.equals("cooldown")) {
            // From cooldown, we can either buy or stay in cooldown
            int buyAction = -prices[idx] + solve(prices, idx + 1, "buy");
            int stayAction = solve(prices, idx + 1, "cooldown");
            result = Math.max(buyAction, stayAction);
            
        } else if (prevAction.equals("buy")) {
            // From buy state, we can either sell or hold (stay in buy state)
            int sellAction = prices[idx] + solve(prices, idx + 1, "sell");
            int holdAction = solve(prices, idx + 1, "buy");
            result = Math.max(sellAction, holdAction);
            
        } else if (prevAction.equals("sell")) {
            // From sell state, we must cooldown (no choice)
            result = solve(prices, idx + 1, "cooldown");
        }
        
        dp.put(key, result);
        return result;
    }
}

// Alternative cleaner approach using 0/1 states instead of strings
class SolutionOptimized {
    Map<String, Integer> memo;
    
    public int maxProfit(int[] prices) {
        memo = new HashMap<>();
        return dfs(prices, 0, 0); // start at index 0, state 0 (can buy)
    }
    
    private int dfs(int[] prices, int i, int state) {
        if (i >= prices.length) return 0;
        
        String key = i + "-" + state;
        if (memo.containsKey(key)) return memo.get(key);
        
        int result = 0;
        
        if (state == 0) { // Can buy
            // Either buy today or skip
            int buy = -prices[i] + dfs(prices, i + 1, 1); // Move to "holding" state
            int skip = dfs(prices, i + 1, 0); // Stay in "can buy" state
            result = Math.max(buy, skip);
            
        } else { // state == 1, holding stock
            // Either sell today or hold
            int sell = prices[i] + dfs(prices, i + 1, 2); // Move to "cooldown" state
            int hold = dfs(prices, i + 1, 1); // Stay in "holding" state
            result = Math.max(sell, hold);
            
        } // Note: state 2 (cooldown) automatically transitions to state 0 next day
        
        if (state == 2) { // Cooldown (can't buy today)
            result = dfs(prices, i + 1, 0); // Must transition to "can buy" state
        }
        
        memo.put(key, result);
        return result;
    }
}
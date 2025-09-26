import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> dp;

    public int maxProfit(int[] prices) {
        dp = new HashMap<>();

        return solve(prices, 0, "cooldown");

    }

    int solve(int[] prices, int idx, String prevAction) {
        if (idx >= prices.length)
            return 0;

        String temp = idx + prevAction;
        if (dp.containsKey(temp))
            return dp.get(temp);

        int buyAction = 0;
        int sellAction = 0;
        int coolDownAction = 0;

        if (prevAction.equals("cooldown"))
            buyAction = -prices[idx] + solve(prices, idx + 1, "buy");
        if (prevAction.equals("buy"))
            sellAction = prices[idx] + solve(prices, idx + 1, "sell");
        if (prevAction.equals("sell"))
            coolDownAction = solve(prices, idx + 1, "cooldown");

        int result = Math.max(
                buyAction,
                Math.max(
                        sellAction,
                        coolDownAction
                )
        );


        dp.put(temp, result);
        return result;

    }
}
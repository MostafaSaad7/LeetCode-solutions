class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;

        for(int stockPrice : prices)
        {
            int currentProfit = stockPrice - buy;
            if(currentProfit >= 0)
            {
                maxProfit = Math.max(maxProfit,currentProfit);
            }
            else
            {
                buy = stockPrice;
            }

        } 
        return maxProfit;
    }
}
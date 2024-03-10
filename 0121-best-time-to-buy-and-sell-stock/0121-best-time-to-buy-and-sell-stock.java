class Solution {
    public int maxProfit(int[] prices) {
        int maxProf=0;
        int minElem=prices[0];
        for (int i =1 ; i < prices.length;i++)
        {
            int diff = prices[i]-minElem;
            if (diff>0)
            {
                maxProf=Math.max(diff,maxProf);
            }
            else
            {
                minElem=prices[i];
            }
        }

        return maxProf;
    }
}
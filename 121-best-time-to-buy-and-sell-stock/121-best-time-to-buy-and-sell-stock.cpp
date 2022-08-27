class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxPriceIndex =0;
        int leastPriceIndex=0;
        int maxDiff =0;
        for(int i =1 ; i< prices.size();i++ )
        {
            int  diff = prices[i]-prices[leastPriceIndex];
            if(diff>0 && diff > maxDiff)
            {
            maxDiff= diff;
            maxPriceIndex=i;
            
            }
            else if (diff < 0 )
            {
                leastPriceIndex=i;
            }
        }
        
    return maxDiff;
        
    }
};
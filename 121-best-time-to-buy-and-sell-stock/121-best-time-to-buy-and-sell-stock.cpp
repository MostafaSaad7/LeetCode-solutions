class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxPriceIndex =1;
        int leastPriceIndex=0;
        int maxDiff =0;
        while(maxPriceIndex<prices.size())
        {
            if(prices[leastPriceIndex]<prices[maxPriceIndex])
            {
                maxDiff=max(maxDiff,prices[maxPriceIndex]-prices[leastPriceIndex]);
                
            }
            else
                leastPriceIndex=maxPriceIndex;
            
            maxPriceIndex++;
            
        }
        
        
    return maxDiff;
        
    }
};
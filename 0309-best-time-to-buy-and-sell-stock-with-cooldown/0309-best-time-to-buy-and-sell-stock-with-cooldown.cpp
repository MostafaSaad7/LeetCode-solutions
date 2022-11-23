vector<int> g;
const int MAX = 5000 + 1;
int memory[MAX][2];
class Solution
{
public:
    int dp(int index, int canBuy = 1)
    {
        if (index >= g.size())
            return 0;
        int &ret = memory[index][canBuy];
        if (ret != -1)
            return ret;
        // buy
        int buy = 0;
        if(canBuy)
        buy = -g[index] + dp(index + 1, 0);
        int doN = 0;
        doN = 0 + dp(index + 1, canBuy);
        // sell
        int sell = 0;
        if (!canBuy)
            sell = g[index] + dp(index + 2, 1);

        return ret = max({buy, sell, doN});
    }
    int maxProfit(vector<int> &prices)
    {
        g = prices;
        memset(memory, -1, sizeof(memory));
        return dp(0);
    }
};
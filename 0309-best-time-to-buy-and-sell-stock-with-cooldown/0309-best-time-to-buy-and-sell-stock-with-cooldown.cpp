vector<int> g;
const int MAX = 5000 + 1;
int memory[MAX][2][3];
const int BUY = 0;
const int SELL = 1;
const int NOTHING = 2;

class Solution
{
public:
    int dp(int index, int canBuy = 1, int prevState = 2)
    {
        if (index >= g.size())
            return 0;
        int &ret = memory[index][canBuy][prevState];
        if (ret != -1)
            return ret;
        // buy
        int buy = 0;
        if (canBuy && prevState != SELL)
            buy = -g[index] + dp(index + 1, 0, BUY);

        int doN = 0;
        doN = dp(index + 1, canBuy, NOTHING);
        // sell
        int sell = 0;
        if (!canBuy)
            sell = g[index] + dp(index + 1, 1, SELL);

        return ret = max({buy, sell, doN});
    }
    int maxProfit(vector<int> &prices)
    {
        g = prices;
        memset(memory, -1, sizeof(memory));
        return dp(0);
    }
};
class Solution
{
public:
    int minCostClimbingStairs(vector<int> &cost)
    {
        vector<int> dp(cost.size()+1, 0);
        for (int i =2; i <dp.size(); i++)
        {
            int c1 = cost[i-1] + dp[i - 1];
            int c2 = cost[i-2] + dp[i - 2];
            dp[i] = min(c1, c2);
        }

        return dp[cost.size()];
    }
};
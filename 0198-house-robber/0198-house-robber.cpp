vector<int> g;
const int MAX = 100 + 1;
int memory[MAX];
class Solution
{
public:
    int dp(int index)
    {
        if (index >= g.size())
            return 0;
        int &ret = memory[index];
        if (ret != -1)
            return ret;

        int leave = dp(index + 1);
        int take = g[index] + dp((index + 2));

        return ret = max(leave, take);
    }
    int rob(vector<int> &nums)
    {
        g = nums;
        memset(memory, -1, sizeof(memory));
        return dp(0);
    }
};
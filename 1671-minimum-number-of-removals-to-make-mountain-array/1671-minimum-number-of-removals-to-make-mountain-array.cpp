vector<int> g;
const int MAX = 1000 + 5;
int memory[MAX][2];
const int INCREASING = 0;
const int DECREASING = 1;

class Solution
{
    // longest increasing subsequence ends at index
    int dpInc(int index)
    {
        if (index < 0)
            return 0;
        int &ret = memory[index][INCREASING];
        if (ret != -1)
            return ret;
        ret = 0;
        for (int i = 0; i < index; i++)
        {
            if (g[i] < g[index])
                ret = max(ret, dpInc(i));
        }
        ret = ret + 1;
        return ret;
    }

    // longest decreasing subsequence from current index
    int dpDec(int index)
    {
        if (index == g.size())
            return 0;
        int &ret = memory[index][DECREASING];
        if (ret != -1)
            return ret;
        ret = 0;
        for (int i = index + 1; i < g.size(); i++)
        {
            if (g[i] < g[index])
                ret = max(ret, dpDec(i));
        }
        ret = ret + 1;
        return ret;
    }

public:
    int minimumMountainRemovals(vector<int> &nums)
    {
        g = nums;
        memset(memory, -1, sizeof(memory));
        int res = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (dpDec(i) == 1 || dpInc(i) == 1)
                continue;
            int temp = dpDec(i) + dpInc(i) - 1;
            res = max(res, temp);
        }
        return nums.size() - res;
    }
};
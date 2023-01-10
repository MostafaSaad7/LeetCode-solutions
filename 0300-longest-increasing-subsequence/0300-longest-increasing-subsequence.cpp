const int MAX = 2500 + 5;
int bestChoice[MAX];

class Solution
{
public:
    vector<int> v;
    int dp(int index)
    {
        if (index == v.size())
            return 0;
        int &ret = bestChoice[index];
        if (ret != -1)
            return ret;
        ret = 0;
        for (int i = index + 1; i < v.size(); i++)
        {
            if (v[i] > v[index])
                ret = max(ret, dp(i));
        }
        ret += 1;
        return ret;
    }

public:
    int lengthOfLIS(vector<int> &nums)
    {
        v.push_back(INT32_MIN);
        for (auto i : nums)
            v.push_back(i);
        memset(bestChoice, -1, sizeof(bestChoice));
        return dp(0) - 1;
    }
};
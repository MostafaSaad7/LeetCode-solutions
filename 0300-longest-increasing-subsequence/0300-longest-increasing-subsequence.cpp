const int MAX = 2500 + 1;
int memory[MAX];
class Solution
{
public:
    int dp(vector<int> &nums, int idx)
    {
        if (idx == nums.size())
            return 0;

        auto &ret = memory[idx];
        if (ret != -1)
            return ret;
        ret = 0;
        for (int i = idx + 1; i < nums.size(); i++)
        {
            if (nums[i] > nums[idx])
                ret = max(ret, dp(nums, i));
        }

        ret += 1;
        return ret;
    }
    int lengthOfLIS(vector<int> &nums)
    {
        memset(memory, -1, sizeof(memory));
        nums.insert(nums.begin(), INT_MIN);
        return dp(nums, 0) - 1;
    }
};
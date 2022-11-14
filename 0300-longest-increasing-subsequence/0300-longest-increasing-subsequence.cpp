const int MAX = 2500 + 1;
int memory[MAX][MAX];
class Solution
{
public:
    int dp(vector<int> &nums, int idx, int prevIdx)
    {
        if (idx == nums.size())
            return 0;

        auto &ret = memory[idx][prevIdx];
        if (ret != -1)
            return ret;

        int taken = 0;
        int left = 0;

        left = dp(nums, idx + 1, prevIdx);

        if (prevIdx == nums.size() || nums[idx] > nums[prevIdx])
            taken = 1 + dp(nums, idx + 1, idx);

        return ret = max(taken, left);
    }
    int lengthOfLIS(vector<int> &nums)
    {
        memset(memory, -1, sizeof(memory));
        return dp(nums, 0, nums.size());
    }
};
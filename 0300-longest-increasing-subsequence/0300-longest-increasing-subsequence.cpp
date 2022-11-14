const int MAX = 2500 + 1;
int memory[MAX][MAX];
class Solution
{
public:
    int dp(vector<int> &nums, int idx, int prevIdx)
    {
        if (idx == nums.size())
            return 0;

        if (prevIdx != -1 && memory[idx][prevIdx] != -1)
            return memory[idx][prevIdx];

        int taken = 0;
        int left = 0;

        left = dp(nums, idx + 1, prevIdx);

        if (prevIdx == -1 || nums[idx] > nums[prevIdx])
            taken = 1 + dp(nums, idx + 1, idx);
        int res = 1;
        if (prevIdx != -1)
            res = memory[idx][prevIdx] = max(taken, left);
        else
            res = max(taken, left);
        return res;
    }
    int lengthOfLIS(vector<int> &nums)
    {
        memset(memory, -1, sizeof(memory));
        return dp(nums, 0, -1);
    }
};
vector<int> g;
const int MAX = 200 + 1;
int memory[MAX][(200 * 100 + 1)];
class Solution
{

    bool dp(int idx, int remaining)
    {
        if (remaining == 0)
            return true;
        if (idx == g.size() || remaining < 0)
            return false;
        int &ret = memory[idx][remaining];
        if (ret != -1)
            return ret;
      

        return ret = dp(idx + 1, remaining) ||   dp(idx + 1, remaining - g[idx]);
    }

public:
    bool canPartition(vector<int> &nums)
    {
        int sum = 0;
        g = nums;
        memset(memory, -1, sizeof(memory));
        for (int i : nums)
        {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        return dp(0, sum / 2);
    }
};
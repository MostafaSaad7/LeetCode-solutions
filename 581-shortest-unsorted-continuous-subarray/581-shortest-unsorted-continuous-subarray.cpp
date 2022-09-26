
class Solution
{
public:
    int findUnsortedSubarray(vector<int> &nums)
    {
        int left = -1;
        int right = -1;
        int minS = INT_MAX;
        int maxS = INT_MIN;
        for (int i = 0; i < nums.size(); i++)
        {
            maxS = max(maxS, nums[i]);
            if (maxS> nums[i])
                right = i;
        }
        for (int i = nums.size() - 1; i>= 0; i--)
        {
            minS = min(minS, nums[i]);
            if (minS < nums[i])
                left = i;
        }

        if (left == -1)
            return 0;
        return right - left + 1;
    }
};
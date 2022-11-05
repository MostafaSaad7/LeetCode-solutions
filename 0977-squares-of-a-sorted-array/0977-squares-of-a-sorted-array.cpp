class Solution
{
public:
    vector<int> sortedSquares(vector<int> &nums)
    {
        vector<int> res;

        int left = 0, right = nums.size() - 1;
        while (left <= right)
        {
            int numR = abs(nums[right]);
            int numL = abs(nums[left]);
            if (numR > numL)
            {
                res.push_back(numR * numR);
                right--;
            }
            else
            {
                res.push_back(numL * numL);
                left++;
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
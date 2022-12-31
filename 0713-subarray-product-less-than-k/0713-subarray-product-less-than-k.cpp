class Solution
{
public:
    int numSubarrayProductLessThanK(vector<int> &nums, int k)
    {
        if(k<=1) return 0;
        int ans = 0;
        int start = 0, end = 0;
        int mulResult = 1;
        while (end < nums.size())
        {
            mulResult *= nums[end];

            while (mulResult >= k)
            {
                mulResult = mulResult / nums[start];
                start++;
            }

            ans += end - start + 1;
            end++;
        }
        return ans;
    }
};
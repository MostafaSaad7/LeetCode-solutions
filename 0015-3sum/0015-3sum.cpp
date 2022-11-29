class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for (int i = 0; i <= nums.size() - 3; i++)
        {

            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right)
            {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0)
                {
                    res.push_back({nums[i], nums[left], nums[right]});
                    int templ=nums[left];
                    int tempr=nums[right];
                    // check if there are repeated values
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }
                else if (target < 0)
                    left++;
                else
                    right--;
            }
        while (i + 1 <= nums.size()-3 && nums[i + 1] == nums[i]) 
            i++;
            
        }
        return res;
    }
};
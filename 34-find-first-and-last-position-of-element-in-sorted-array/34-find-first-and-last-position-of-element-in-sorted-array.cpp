class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> v (2,-1);
        auto p = equal_range(nums.begin(),nums.end(),target);
        if(p.first ==nums.end())
            return v;
        else if(nums[p.first - nums.begin()] == target )
        {
            v[0]=p.first - nums.begin();
            v[1]=p.second-nums.begin()-1;
        }
            return v;
        
    }
};
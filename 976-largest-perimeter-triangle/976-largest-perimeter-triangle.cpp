class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        int res = 0 ;
        sort(nums.begin(),nums.end());
        for(int i = 2 ;i<nums.size();i++ )
        {
            if(nums[i]<(nums[i-1]+nums[i-2]))
            {
                res = max(res , (nums[i]+nums[i-1]+nums[i-2]));
            }
        }
        
        return res ;
    }
};
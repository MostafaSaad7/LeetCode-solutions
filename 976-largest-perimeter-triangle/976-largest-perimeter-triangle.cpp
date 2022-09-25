class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        int res = 0 ;
        sort(nums.begin(),nums.end());
        for(int i = (int)nums.size()-1 ; i > 1 ; i-- )
        {
            int sum = nums[i-1]+nums[i-2];
            if(nums[i] < sum)
            {
                res = max(res , (nums[i]+sum));
            }
        }
        
        return res ;
    }
};
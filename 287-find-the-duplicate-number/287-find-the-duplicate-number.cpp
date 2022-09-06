class Solution {
public:
    int findDuplicate(vector<int>& nums) {
    int res = 0;
        sort(nums.begin(),nums.end());
        int i =0,j=i+1 ;
        while(i < nums.size())
        {
            if(nums[i]==nums[j])
            {
                res=nums[i];
                break;
            }
            else
            {
                i=j;
                j++;
            }
        }
        return res;
    }
};
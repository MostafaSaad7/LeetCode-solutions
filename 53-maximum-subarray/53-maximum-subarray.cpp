#include<vector>
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max_sum=-1e5;
        int StartIndex=0;
		int subarr=0;
        for(int i =0 ; i<nums.size();i++)
		{
			subarr+=nums[i];

            if(subarr>max_sum)
                max_sum=subarr;
			if(subarr<0)
            {
                subarr=0;
            }
		}
        
        return max_sum;
    }
};
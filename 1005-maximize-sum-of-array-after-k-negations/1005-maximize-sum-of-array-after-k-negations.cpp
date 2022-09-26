class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        int sum=0;
        int minNum=INT_MAX;
        sort(nums.begin(),nums.end());
        for(int i = 0 ;i < nums.size();i++)
        {
            if(k&& nums[i]<0) 
            {
                k--;
                nums[i]*=-1;
            }
            sum+=nums[i];
            minNum= min(minNum,nums[i]);
        }
        
        
        if(k%2==1)
            sum-=2*minNum;
        
        return sum;

    }
};
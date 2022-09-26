class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int left = -1 ; 
        int right =-1;
        vector<int> temp(nums.size());
        for(int i =0 ; i< nums.size(); i++)
        {
            temp[i]=nums[i];
   
        }
     sort(temp.begin(),temp.end());
         for(int i =0 ; i< nums.size(); i++)
        {
            if(temp[i]!=nums[i])
            {
                if(left==-1)
                    left=i;
                right=i+1;
            }
   
        }
        return right-left;
    }
};
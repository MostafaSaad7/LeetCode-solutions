class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major= nums[0];
        int counter = 1 ;
        for(int i = 01; i < nums.size();i++)
            {
                
                if(nums[i]==major)
                    counter++;
            else if (nums[i]!=major && counter == 0)
            {
                major = nums[i];
                counter = 1;
            }
            else 
                counter --;
            }
        return major ;
    }
};
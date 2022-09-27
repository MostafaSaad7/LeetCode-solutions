class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
     
        vector<int> v (2,-1);
        int low = lower( nums, target);
        if(low == -1)
            return v;
        int upp = upper( nums, target);
            
        v[0]=low;
        if(upp==-1)
            upp=nums.size();
        v[1]=upp-1;
        return v;
        
    }
    
    int lower(vector<int>& nums, int target) {
        int res =-1;
       if(nums.size()==0||target < nums[0] || target > nums[nums.size()-1])
            return res;
        int left = 0 ; 
        int right = nums.size()-1;
        
        while(left<=right)
        {
            int mid= left+(right-left)/2;
            if(nums[mid] == target)
            {
                 res = mid;
                right = mid -1 ;            
            }
            else if (target < nums[mid])
                    right = mid -1 ;
            else
                left=mid+1;
        }
        
        return res;
    }
    int upper(vector<int>& nums, int target) {
        int left = 0 ; 
        int res =-1;
        int right = nums.size()-1;
        
        while(left<=right)
        {
            int mid= left+(right-left)/2;
            if(nums[mid] > target)
            {
                res = mid;
                right = mid-1;
            }
            else
                left=mid+1;
            
        }
        
        return res;
    }

};
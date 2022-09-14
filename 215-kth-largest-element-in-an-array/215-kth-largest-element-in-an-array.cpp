class Solution {
        
public:
    int findKthLargest(vector<int>& nums, int k) {

        return quickSelection(nums , 0, nums.size()-1,nums.size()-k);
    }
    
    int quickSelection(vector<int>& nums,int left , int right,int k)
    {
        int  piviot = nums [right];
        int p = left;
        for(int i =left ;  i<right;i++)
        {
            if(nums[i] <= piviot)
            {
                swap(nums[i],nums[p]);
                p++; 
            }
        }
        
        swap(nums[p] ,nums[right]);
        
        if(k<p)
            return quickSelection(nums,left,p-1,k);
        else if(k>p)
            return quickSelection(nums,p+1,right,k);
        else
            return nums[p];
    }
    
};
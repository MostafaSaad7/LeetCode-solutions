class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int min =nums[0];
        int maxN = nums[0];
        
        for (int i =1 ; i< nums.size(); i++)
        {
            if(nums[i] < min)
                min = nums[i];         
        }
        
        min =abs(min);
        
        for (int i =0 ; i< nums.size(); i++)
        {
            nums[i]+=min;
            
        }
        for (int i =0 ; i< nums.size(); i++)
        {
            if(nums[i] > maxN)
                maxN = nums[i];         
        }
        
        vector<int > vec (maxN+1);
        
        for (int i =0 ; i< nums.size(); i++)
        {
            vec[nums[i]]+=1;
        }
        
        int idx=0;
        for(int i = 0 ; i <= maxN ; i++)
        {
            for(int j = 0 ; j < vec[i]; j++,idx++)
            {
                nums[idx]=i-min ;
            }
        }
        
        return nums;
    }
};
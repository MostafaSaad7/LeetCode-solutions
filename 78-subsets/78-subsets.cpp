class Solution {
    private :
            vector<vector<int>> res;
            vector <int > v;

public:
    vector<vector<int>> subsets(vector<int>& nums) {
        fun(nums,0);
        return res;
    }
    
    void fun (vector<int>& nums , int i )
    {
        if(i >= nums.size())
        {
            res.push_back(v);
            return;
        }
            v.push_back(nums[i]);
            fun(nums , i+1);
        v.pop_back();
        fun(nums , i+1);
        
    }
};
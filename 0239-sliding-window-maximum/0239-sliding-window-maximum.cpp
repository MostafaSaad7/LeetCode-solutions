class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res;
        
        if((int)nums.size()<k )
            return res;
        multiset<int >mlset;
        for(int i =0 ; i < k ; i++)
        {
            mlset.insert(-nums[i]);
            
        }
        
        res.push_back(-*mlset.begin());
        
        for(int i =k ; i < (int)nums.size() ; i++)
        {
            mlset.erase(mlset.find(-nums[i-k]));
            mlset.insert(-nums[i]);
            res.push_back(-*mlset.begin());
            
        }
        return res;
    }
};
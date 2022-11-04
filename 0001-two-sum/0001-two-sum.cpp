class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        unordered_map<int , int> m;

        for(int i = 0 ; i <nums.size(); i++)
        {
            int diff= target - nums [i];
            if(m.find(diff)!=m.end())
            {
                res.push_back(i);
                res.push_back(m[diff]);
                return res;

            }
              else
               m[nums[i]]=i;
            
        }
            
      
        return res;
        
    }
};
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
    int res = 0;
        unordered_set <int > s(nums.size());
        for(int & x : nums )
            if(s.count(x)==1)
                return x ;
            else 
                s.insert(x);
        
        return res;
    }
};
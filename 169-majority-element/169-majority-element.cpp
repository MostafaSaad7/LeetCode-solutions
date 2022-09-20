class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int ,int > mp ;
        for(int & num : nums )
        {
            if(mp.count(num)==0)
                mp[num]=1;
            else
                mp[num]++;
            
        }
        
    for(int & num : nums )
        {
            if(mp[num]>nums.size()/2)
                return num;
            
        }
        
        return -1;
        
        
    }
};
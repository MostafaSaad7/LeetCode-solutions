class Solution {
public:

    int singleNumber(vector<int>& nums) {
        int res = 0;
        unordered_map<int,int >mp ;
        
        for(int num : nums)
        {
            if(mp.count(num)==0)
                mp[num]=1;
            else
            {
               mp[num]++;

            }    
        }    
        for(int num : nums)
        {
            if(mp[num]==1)
                return num;
            
        } 
        return res;

    }
};
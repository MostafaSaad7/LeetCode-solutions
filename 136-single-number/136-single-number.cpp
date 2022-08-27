class Solution {
public:
    // just XOR elements with each other 
    //same elements cancel each other 
    int singleNumber(vector<int>& nums) {
        int res = 0;
        for(int num : nums)
            res^=num;
        return res;
        
 
    }
};
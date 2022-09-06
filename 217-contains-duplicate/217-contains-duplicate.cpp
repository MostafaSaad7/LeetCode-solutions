class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> s;
        for(int i : nums) {
            if(s.insert(i).second==0) return true;
        }
        return false;
    }
};
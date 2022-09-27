class Solution {
public:
    int search(vector<int>& nums, int target) {
      
      auto it = lower_bound(nums.begin(),nums.end(),target);
        if(it==nums.end())
        return -1;
        return (nums[it-nums.begin()]==target? it-nums.begin():-1);

    }
};


class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        // int arr[2001]={0};//try map 
        unordered_map <int ,int> mp(1001);
        vector <int> v;
        for(int i =0 ; i < nums1.size();i++)
        {
            mp[nums1[i]]+=1;
        }
          for(int i =0 ; i < nums2.size();i++)
        {
              if(mp[nums2[i]]>0)
              {
                  mp[nums2[i]]--;
                  v.push_back(nums2[i]);
              }
           
        }
        
        return v;
        
        
    }
};
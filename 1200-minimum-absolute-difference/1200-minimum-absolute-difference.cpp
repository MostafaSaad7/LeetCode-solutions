class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector <vector<int>>res;
        sort(arr.begin(),arr.end());
        int  minDiff = INT_MAX;
            
        for(int i =1 ; i< arr.size();i++)
        {
            minDiff = min (arr[i]-arr[i-1],minDiff);

            
        }
        
        
        for(int i =1 ; i< arr.size();i++)
        {
            if(abs(arr[i]-arr[i-1])==minDiff)
            {
                res.push_back({arr[i-1],arr[i]});
            }

            
        }
        
        
        
        return res;
    }
};
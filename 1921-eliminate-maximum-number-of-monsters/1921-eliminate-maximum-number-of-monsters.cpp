class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed)     {
        vector<double> reqMin(dist.size());
        int killed =0;
        for(int i = 0 ; i < speed.size(); i++)
        {
            reqMin[i]=(double)dist[i]/speed[i];
        }
        
        sort(reqMin.begin(),reqMin.end());
        for(int i = 0 ; i < speed.size() && i<reqMin[i]; i++)
        {
            killed++;
        }
      
        return killed;
    }
};
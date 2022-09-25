class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed)     {
        vector<double> reqMin(dist.size());
        int min = 0;
        int killed =0;
        for(int i = 0 ; i < speed.size(); i++)
        {
            reqMin[i]=(double)dist[i]/speed[i];
        }
        
        sort(reqMin.begin(),reqMin.end());
        for(int i = 0 ; i < speed.size(); i++)
        {
            if(reqMin[i]-min<=0.0)
            {
                break;
            }
                killed++;
            min++;
        }
      
        return killed;
    }
};
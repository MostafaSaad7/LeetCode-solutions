class Solution {
public:
    vector<int> countBits(int n) {
        vector <int >DP (n+1);
        DP[0]=0;
 
        
        for(int i =1 ; i <n+1; i++)
        {
            if(i%2==0)
            {
                int even = i/2;
                DP[i]=DP[even];
        
            }
            else 
                DP[i]=1+DP[i-1];
        }
        
        return DP;
        
    }
};
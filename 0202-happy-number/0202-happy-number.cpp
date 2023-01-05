class Solution
{
public:
    bool isHappy(int n)
    {
        unordered_map<int,bool>mp(1e6);
       
       while(!mp[n]) {
            mp[n]=1;
            int newNum = 0;
            while (n > 0)
            {
                newNum += (n % 10) *(n%10);
                n = n / 10;
            }
            n = newNum;
        }
        return n==1;
    }
};
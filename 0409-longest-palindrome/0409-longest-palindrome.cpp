class Solution
{
public:
    int longestPalindrome(string s)
    {
        int res = 0;
        unordered_map<char, int> mp;
        bool odd=0;
        for (int i = 0; i < s.size(); i++)
        {
            mp[s[i]]++;
        }

        for (auto i : mp)
        {
            if(i.second %2 ==0 )
             res += i.second;
            else
            {
                odd=1;
                res+=i.second-1;
            }
                
        }
        

        return res + odd;
        
    }
};
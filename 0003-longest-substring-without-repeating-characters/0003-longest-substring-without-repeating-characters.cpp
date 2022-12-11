class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> mp;
        int subLen = 0;
        int start = 0;
        for (int i = 0; i < s.size(); i++)
        {
            while (mp[s[i]] && start < s.size())
            {
                mp[s[start]]--;
                start++;
            }
            mp[s[i]]++;
            subLen = max(subLen, i - start + 1);
        }

        return subLen;
    }
};
class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_set<char> st;
        int subLen = 0;
        int start = 0;
        for (int i = 0; i < s.size(); i++)
        {
            while (st.count(s[i]) != 0 && start < s.size())
            {
                st.erase(s[start]);
                start++;
            }
            st.insert(s[i]);
            subLen = max(subLen, i - start + 1);
        }

        return subLen;
    }
};
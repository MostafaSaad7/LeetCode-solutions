class Solution
{
    vector<string> split(string s, string delimiter)
    {
        size_t pos_start = 0, pos_end, delim_len = delimiter.length();
        string token;
        vector<string> res;

        while ((pos_end = s.find(delimiter, pos_start)) != string::npos)
        {
            token = s.substr(pos_start, pos_end - pos_start);
            pos_start = pos_end + delim_len;
            res.push_back(token);
        }

        res.push_back(s.substr(pos_start));
        return res;
    }

public:
    bool wordPattern(string pattern, string s)
    {
        istringstream is(s);
        vector<string> ss = split(s, " ");
        unordered_map<char, string> mp;
        unordered_set<string> st;
        if (ss.size() != pattern.size())
            return false;
        for (int i = 0; i < pattern.size(); i++)
        {
            string temp = ss[i];
            if (mp.count(pattern[i]) == 0)
            {
                if (st.count(temp) != 0)
                    return false;
                mp[pattern[i]] = temp;
                st.insert(temp);
            }
            else if (mp[pattern[i]] == temp)
            {
                continue;
            }
            else
                return false;
        }
        return true;
    }
};
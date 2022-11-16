class Solution {
public:
    bool isAnagram(string s, string t) {
               int alpha[26] = {};
           if(t.size()!=s.size())
               return false;
        for(int i =0 ;i < t.size();i++)
        {
            alpha[t[i]-'a']++;
        }
        
        for(int i = 0; i < s.size(); i++)
            if(--alpha[s[i]-'a'] <0 )
                return false;
    return true;
    }
};
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
       int alpha[26] = {};
           
        for(int i =0 ;i < magazine.size();i++)
        {
            alpha[magazine[i]-'a']++;
        }
        
        for(int i = 0; i < ransomNote.size(); i++)
            if(--alpha[ransomNote[i]-'a'] <0 )
                return false;
    return true;
        
    }
};
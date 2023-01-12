class Solution {
public:
    int lengthOfLastWord(string s) {
        int spaceIndex = s.size()-1;
        int length= 0;
        while(s[spaceIndex]==' ') // igonre ending spaces 
            spaceIndex--;
        while(spaceIndex>=0 && s[spaceIndex]!=' ')
        {
            length++;
            spaceIndex--;
        }
        
        return length;
    }
};
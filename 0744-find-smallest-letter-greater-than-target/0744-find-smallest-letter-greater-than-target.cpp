class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int left =0;
        int right =letters.size()-1;
        char res = letters[0];
        while(left <= right)
        {
            int mid =(left+right)/2;
            if(letters[mid] > target)
            {
                res=letters[mid];
                right = right-1;
                
            }
            else
                left=left+1;
        }
 
        
        return res;
    }
};
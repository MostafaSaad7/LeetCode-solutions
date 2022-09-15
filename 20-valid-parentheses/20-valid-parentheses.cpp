class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        for(int i=0 ; i< s.size();i++)
        {
            if(isOpening(s[i]))
                stk.push(s[i]);
            else
            {
                if(!stk.empty() && isValidClosing(stk.top(),s[i]))
                    stk.pop();
                else
                    return false;
            }
            
        }
        
        if(stk.empty())
            return true;
        return false;
        
    }
    
    bool isOpening (char c )
    {
        if(c =='(' || c == '{' || c == '[' )
            return true;
        return false;
    }
    
    bool isValidClosing(char open , char close)
    {
        if(close == ')' && open == '(')
            return true;
        if(close == '}' && open == '{')
            return true;
        if(close == ']' && open == '[')
            return true;
        return false;
    }
};
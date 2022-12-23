class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i = 0 ; i < 9 ; i++)
        {
            unordered_set <char> s1;
            unordered_set <char> s2;
            for(int j =0 ; j < 9 ;j++)
            {
                if(board[i][j]!='.' && s1.count(board[i][j]))
                    return false;
                if(board[j][i]!='.' && s2.count(board[j][i]))
                    return false;
                s1.insert(board[i][j]);
                s2.insert(board[j][i]);        
            }
            s1.clear();
            s2.clear();
            
        }
        
        int i = 0,j = 0;
        while(i<9)
        {    
            unordered_set <char> s;
            for(int x = i ; x <i+3 ; x++)
            {            
                for(int y =j ; y < j+3 ;y++)
                {
                    if(board[x][y]>='1'&& board[x][y]<='9' && s.count(board[x][y]))
                        return false;
                    s.insert(board[x][y]);
                }
            }
            s.clear();
            j+=3;
            if(j>=9)
            {
                i+=3;
                j=0;
            }
            
            
            
        }
        
        return true;
        
    }
};
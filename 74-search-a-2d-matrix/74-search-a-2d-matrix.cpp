class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int col= matrix[0].size();
        for(int i =0 ; i< matrix.size();i++)
        {
            for(int j =0 ; j <col ;j++)
            {
                if(target>matrix[i][col-1])
                    break;
                else
                {
                    if(matrix[i][j]==target)
                        return true;
                }
                
            }
        }
        
        return false;
        }
};
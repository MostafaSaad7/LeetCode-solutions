class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        const int cols= matrix[0].size();
        const int rows = matrix.size();
        //binary search for row
        int top=0, bottom = rows-1,row=-1;
        while(top<=bottom)
        {
             row = (top+bottom)/2;
            if(matrix[row][0] > target)
                    bottom= row-1;
            else if (matrix[row][cols-1] < target)
                    top= row+1;
            else
                break;
        
                   
        }
        
        if(top>bottom)
            return false;
        
        
        //binary search for target 
        int left = 0 , right = cols -1 ;
        while(left <=right)
        {
            int middle =(left+right)/2;
            if(matrix[row][middle] > target)
                right = middle-1;
            else if (matrix[row][middle] < target)
                left = middle+1;
            else 
                return true;
            
        }
        return false;
        }
};
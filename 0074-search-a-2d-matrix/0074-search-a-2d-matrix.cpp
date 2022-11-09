class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int low = 0;
        int high = matrix.size() - 1;
        int row;
        while (low <= high)
        {
            row = (low + high) / 2;

            if (target < matrix[row][0])
                high = row - 1;
            else if (target > matrix[row][matrix[row].size() - 1])
                low = row + 1;
            else
                break;
        }

        if (low > high)
            return false;

        low = 0, high = matrix[row].size() - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
};
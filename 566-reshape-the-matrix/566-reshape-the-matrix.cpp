class Solution
{
public:
    vector<vector<int>> matrixReshape(vector<vector<int>> &mat, int r, int c)
    {
        int row = 0, col = 0;
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> res;
        if (r * c != m*n)
        {
            return mat;
        }
        for (int i = 0; i < r; i++)
        {
            vector<int> v;
            for (int j = 0; j < c; j++)
            {
                v.push_back(mat[row][col++]);
                if (col == n)
                    row++, col = 0;
            }
            res.push_back(v);
            v.clear();
        }

        return res;
    }
};
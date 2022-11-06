class Solution
{
public:
    int dr[4]{-1, 0, 1, 0};
    int dc[4]{0, 1, 0, -1};
    bool isvalid(int r, int c, vector<vector<int>> &matrix)
    {
        if (r < 0 || r >= (int)matrix.size())
            return false;
        if (c < 0 || c >= (int)matrix[0].size())
            return false;
        return true;
    }
    int dfs(int i, int j, vector<vector<int>> &matrix, vector<vector<int>> &cache)
    {

        if (cache[i][j])
            return cache[i][j];
        for (int d = 0; d < 4; ++d)
        {
            int nr = i + dr[d], nc = j + dc[d];
            if (!isvalid(nr, nc, matrix))
                continue;
            if (matrix[i][j] < matrix[nr][nc])
                cache[i][j] = max(dfs(nr, nc, matrix, cache), cache[i][j]);
        }

        cache[i][j]++;
        return cache[i][j];
    }
    int longestIncreasingPath(vector<vector<int>> &matrix)
    {
        int rows = matrix.size();
        int cols = matrix[0].size();
        vector<vector<int>> cache(rows, vector<int>(cols, 0));

        int res = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                res = max(res, dfs(i, j, matrix, cache));
            }

            /* code */
        }

        return res;
    }
};
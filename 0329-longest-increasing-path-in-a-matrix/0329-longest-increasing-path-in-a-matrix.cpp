class Solution
{
    int dr[4]{-1, 0, 1, 0};
    int dc[4]{0, 1, 0, -1};
    bool isValid(int row, int col, int rows, int cols)
    {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        return true;
    }
    int getInDeg(vector<vector<int>> &matrix, int row, int col)
    {
        int inDeg = 0;
        for (int d = 0; d < 4; d++)
        {
            int r = row + dr[d], c = col + dc[d];
            if (isValid(r, c, matrix.size(), matrix[0].size()) && matrix[row][col] > matrix[r][c])
                inDeg++;
        }
        return inDeg;
    }
    vector<pair<int, int>> getNegibour(int row, int col, vector<vector<int>> &matrix)
    {
        vector<pair<int, int>> v;
        for (int d = 0; d < 4; d++)
        {
            int r = row + dr[d], c = col + dc[d];
            if (isValid(r, c, matrix.size(), matrix[0].size()) && matrix[r][c] > matrix[row][col])
                v.push_back({r, c});
        }
        return v;
    };

public:
    int longestIncreasingPath(vector<vector<int>> &matrix)
    {
        int rows = matrix.size();
        int cols = matrix[0].size();
        vector<vector<int>> indegree(rows, vector<int>(cols));
        queue<pair<int, int>> ready;

        for (int r = 0; r < rows; ++r)
        {
            for (int c = 0; c < cols; ++c)
            {
                indegree[r][c] = getInDeg(matrix, r, c);

                if (indegree[r][c] == 0)
                    ready.push({r, c});
            }
        }
        int level = 0;
        while (!ready.empty())
        {
            int level_sz = ready.size();
            while (level_sz--)
            {

                int row = ready.front().first;
                int col = ready.front().second;
                ready.pop();
                vector<pair<int, int>> neighbours = getNegibour(row, col, matrix);
                for (auto n : neighbours)
                {
                    if (--indegree[n.first][n.second] == 0)
                    {
                        ready.push({n.first, n.second});
                    }
                }
            }
            level++;
        }
        return level;
    }
};
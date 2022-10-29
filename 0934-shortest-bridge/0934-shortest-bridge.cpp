class Solution
{
public:
    int dr[4]{-1, 0, 1, 0};
    int dc[4]{0, 1, 0, -1};

    // DFS
    void DFS(queue<vector<int>> &q, vector<vector<int>> &grid, int row, int col, int requestedColor = 1, int colorToReplace = 2)
    {
        grid[row][col] = colorToReplace;
        q.push({row, col});

        for (int d = 0; d < 4; d++)
        {
            int newRow = row + dr[d], newCol = col + dc[d];
            if (!isValid(newRow, newCol, grid) || grid[newRow][newCol] != requestedColor)
                continue;

            DFS(q, grid, newRow, newCol); /* code */
        }
    }

    bool isValid(int row, int col, vector<vector<int>> &grid)
    {
        return row >= 0 && row < (int)grid.size() && col >= 0 && col < (int)grid[0].size();
    }

    int shortestBridge(vector<vector<int>> &grid)
    {
        bool done = 0;
        queue<vector<int>> q;
        for (int r = 0; r < (int)grid.size() && !done; r++) // run to get CC
            for (int c = 0; c < (int)grid[0].size(); c++)
                if (grid[r][c] == 1)
                {
                    DFS(q, grid, r, c);
                    done = 1;
                    break;
                }

        for (int level = 0, sz = q.size(); !q.empty(); ++level, sz = q.size())
        {
            while (sz--)
            {
                int r = q.front()[0], c = q.front()[1];
                q.pop();

                for (int d = 0; d < 4; ++d)
                {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (!isValid(nr, nc, grid) || grid[nr][nc] == 2 || grid[nr][nc] == 3)
                        continue;

                    if (grid[nr][nc] == 1)
                        return level;
                    q.push({nr, nc});
                    grid[nr][nc] = 3;
                }
            }
        }
        return -1;
    }
};
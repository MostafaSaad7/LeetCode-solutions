class Solution
{
    bool res;

public:
    bool isValid(vector<vector<char>> &grid, int row, int col)
    {
        if (row >= grid.size() || col >= grid[0].size())
            return false;
        return true;
    }

    bool containsCycle(vector<vector<char>> &grid)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] > 'z')
                    continue;
                bool res = DFS(grid, i, j, -1, -1, grid[i][j]);
                if (res)
                    return res;
            }
        }

        return false;
    }

    bool DFS(vector<vector<char>> &grid, int row, int col, int prevRow, int prevCol, char trackedChar)
    {
        if (!isValid(grid, row, col) || (row == prevRow && col == prevCol) || (grid[row][col] != trackedChar && grid[row][col] != trackedChar + 26))
            return false;

        if (grid[row][col] == trackedChar + 26)
            return true;
        grid[row][col] += 26; // visited
        bool res = false;
        if (!(row + 1 == prevRow && col == prevCol))
            res = DFS(grid, row + 1, col, row, col, trackedChar) || res;
        if (!(row - 1 == prevRow && col == prevCol))
            res = DFS(grid, row - 1, col, row, col, trackedChar) || res;
        if (!(row == prevRow && col + 1 == prevCol))
            res = DFS(grid, row, col + 1, row, col, trackedChar) || res;
        if (!(row == prevRow && col - 1 == prevCol))
            res = DFS(grid, row, col - 1, row, col, trackedChar) || res;

        return res;
    }
};
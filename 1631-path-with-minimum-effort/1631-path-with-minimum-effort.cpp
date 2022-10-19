class Solution
{
    int dr[4]{-1, 0, 1, 0};
    int dc[4]{0, 1, 0, -1};

public:
    bool isvalid(int r, int c, vector<vector<int>> &heights)
    {
        if (r < 0 || r >= (int)heights.size())
            return false;
        if (c < 0 || c >= (int)heights[0].size())
            return false;
        return true;
    }

    int minimumEffortPath(vector<vector<int>> &heights)
    {
        int left = 0;
        int right = 1000000;
        int mid = 0;
        int result = right;

        // Binary search for steps
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (ourFunction(heights, mid))
            {
                right = mid - 1;
                result = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return result;
    }

    bool ourFunction(vector<vector<int>> &heights, int maxSteps)
    {
        vector<vector<bool>> visited(heights.size(), vector<bool>(heights[0].size()));
        return DFS(heights, 0, 0, visited, maxSteps);
    }

    bool DFS(vector<vector<int>> &heights, int row, int col, vector<vector<bool>> &visited, int maxSteps)
    {
        if (row == heights.size() - 1 && col == (int)heights[0].size() - 1)
            return true;
        visited[row][col] = true;

        for (int d = 0; d < 4; ++d) // check all neighbours
        {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

            if (!isvalid(newRow, newCol, heights) || abs(heights[row][col] - heights[newRow][newCol]) > maxSteps || visited[newRow][newCol])
                continue;

            if (DFS(heights, newRow, newCol, visited, maxSteps)) // i need only one true so i can i use or ||
                return true;
        }

        return false;
    }
};

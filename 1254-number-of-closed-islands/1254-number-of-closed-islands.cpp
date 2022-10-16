class Solution {
private:
	int dr[4] { -1, 0, 1, 0 };
	int dc[4] { 0, 1, 0, -1 };

	bool is_touched_boundry;

public:
	int isvalid(int r, int c, vector<vector<int>> &grid) {
		if (r < 0 || r >= (int) grid.size())
			return false;
		if (c < 0 || c >= (int) grid[0].size())
			return false;
		return true;
	}

	bool isGridBoundry(int r, int c, vector<vector<int>> &grid) {
		if (r == 0 || r == (int) grid.size() - 1)
			return true;	// first or last row
		if (c == 0 || c == (int) grid[0].size() - 1)
			return true;	// first or last column
		return false;
	}

	void dfs(int r, int c, vector<vector<int>> &grid,int ccid) {
		if (!isvalid(r, c, grid) || grid[r][c]==-1 || grid[r][c] == 1)
			return;		// invalid, visited or non-CC

		if (isGridBoundry(r, c, grid))
        {
			is_touched_boundry = true;
            return;
        }
        grid[r][c]=-1;
		for (int d = 0; d < 4; ++d)
			dfs(r + dr[d], c + dc[d], grid, ccid);
	}

	int closedIsland(vector<vector<int>> &grid) {
		vector<vector<int>> ccIDs(grid.size(), vector<int>(grid[0].size()));
		int rows = grid.size(), cols = grid[0].size(), ccid = 0, count = 0;

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < cols; ++c) {
				if (!grid[r][c]) {	// New CC component of ZEROs
					is_touched_boundry = false;
					dfs(r, c, grid, ++ccid);
					count += !is_touched_boundry;
				}
			}
		}
		return count;
	}
};

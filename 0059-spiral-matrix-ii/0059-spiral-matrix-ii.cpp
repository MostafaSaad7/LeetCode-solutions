class Solution
{
public:
    vector<vector<int>> generateMatrix(int n)
    {
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int counter = 1;
        int d = 0;
        int row = 0;
        int col = 0;
        vector<vector<int>> res(n, vector<int>(n, 0));
        while (counter <= n * n)
        {
            res[row][col] = counter++;
            int nr = ((row + dir[d][0] % n) + n) % n;
            int nc = ((col + dir[d][1] % n) + n) % n;
            if (res[nr][nc] != 0)
                d = (d + 1) % 4;
            row = row + dir[d][0];
            col = col + dir[d][1];
        }

        return res;
    }
};
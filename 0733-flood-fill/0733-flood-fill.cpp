class Solution
{
public:
    bool isValid(vector<vector<int>> &image, int row, int col)
    {
        if (row < 0 || row >= image.size())
            return false;
        else if (col < 0 || col >= image[0].size())
            return false;
        return true;
    }

    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int color)
    {
        DFS(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void DFS(vector<vector<int>> &image, int row, int col, int colorToSearch, int color)
    {
        if (!isValid(image, row, col) || image[row][col] == color || image[row][col] != colorToSearch)
            return;
        image[row][col] = color;
        DFS(image, row + 1, col, colorToSearch, color);
        DFS(image, row - 1, col, colorToSearch, color);
        DFS(image, row, col + 1, colorToSearch, color);
        DFS(image, row, col - 1, colorToSearch, color);
    }
};
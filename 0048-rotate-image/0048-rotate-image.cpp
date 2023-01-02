class Solution
{
public:
    void printMatrix(vector<vector<int>> &matrix)
    {
        int size = matrix.size();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                cout << matrix[i][j] << " ";
            }
            cout << endl;
        }
    }
    void transpose(vector<vector<int>> &matrix)
    {
        int size = matrix.size();

        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    void reverse(vector<vector<int>> &matrix)
    {
        int size = matrix.size();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size / 2; j++)
            {
                swap(matrix[i][j], matrix[i][size - j - 1]);
            }
        }
    }
    void rotate(vector<vector<int>> &matrix)
    {
        transpose(matrix);
        reverse(matrix);
    }
};
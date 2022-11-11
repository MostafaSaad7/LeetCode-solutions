#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int countNlessEqual(vector<vector<int>> &matrix, int mid)
    {
        int count = 0;
        int col = matrix.size() - 1;
        int row = 0;
        while (col >= 0 && row < matrix.size())
        {
            if (matrix[row][col] <= mid)
            {
                count += col + 1;
                row++;
            }
            else
                col--;
        }

        return count;
    }
    int kthSmallest(vector<vector<int>> &matrix, int k)
    {
        int n = matrix.size();
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        int ans = -1;
        while (min <= max)
        {
            int mid = min + (max - min) / 2;
            int counter = countNlessEqual(matrix, mid);
            if (counter >= k)
            {
                ans = mid;
                max = mid - 1;
            }
            else
                min = mid + 1;
        }

        return ans;
    }
};
class Solution
{
public:
    int minHeightShelves(vector<vector<int>> &books, int shelfWidth)
    {
        vector<int> bestChoice(books.size() + 1, 0);
        int n = books.size();
        bestChoice[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            bestChoice[i] = INT_MAX;
            int width = 0;
            int height = 0;
            for (int j = i; j >= 1; j--)
            {
                width += books[j - 1][0];
                height = max(height, books[j - 1][1]);
                if (width > shelfWidth)
                    break;
                bestChoice[i] = min(bestChoice[i], bestChoice[j - 1] + height);
            }
        }
        return bestChoice[n];
    }
};
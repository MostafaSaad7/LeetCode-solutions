class Solution
{
private:
    struct compare
    {
        bool operator()(pair<int, int> const &p1, pair<int, int> const &p2)
        {
            if (p1.first < p2.first)
                return true;
            else if (p1.first == p2.first && p1.second < p2.second)
            {
                return true;
            }

            return false;
        }
    };

    int countSoldiers(int row, vector<vector<int>> &mat)
    {
        int l = 0;
        int r = mat[row].size() - 1;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (mat[row][mid] == 0)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return l; // index of last one
    }

public:
    vector<int> kWeakestRows(vector<vector<int>> &mat, int k)
    {
        priority_queue<pair<int, int>, vector<pair<int, int>>, compare> pq; // soldiers count , row number
        vector<int> ans;
        for (int i = 0; i < mat.size(); i++)
        {
            int numberOfSoldiers = countSoldiers(i, mat);
            pq.push({numberOfSoldiers, i});
            if (pq.size() > k)
            {
                pq.pop();
            }
        }

        for (int i = 0; i < k; i++)
        {
            ans.push_back(pq.top().second);
            pq.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};
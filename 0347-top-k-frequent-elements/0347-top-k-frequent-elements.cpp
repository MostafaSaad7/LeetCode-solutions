
class compare
{
public:
    bool operator()(const pair<int, int> &i, const pair<int, int> &r)
    {

        return i.second < r.second;
    }
};

class Solution
{
public:
    vector<int> topKFrequent(vector<int> &nums, int k)
    { // number --> freq
        unordered_map<int, int> mp;
        priority_queue<pair<int, int>, vector<pair<int, int>>, compare> q;
        vector<int> res;
        for (auto i : nums)
        {
            mp[i]++;
        }

        for (auto i : mp)
        {
            q.push(i);
        }

        for (int i = 0; i < k; i++)
        {
            res.push_back(q.top().first);
            q.pop();
        }

        return res;
    }
};

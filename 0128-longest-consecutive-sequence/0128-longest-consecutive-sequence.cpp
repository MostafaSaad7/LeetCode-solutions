class Solution
{

public:
    int longestConsecutive(vector<int> &nums)
    {

        unordered_set<int> s(nums.begin(), nums.end());
        int longestSofar = 0;
        for (auto num : s)
        {
            if (s.count(num - 1) == 0)
            {
                int conseq = 1;

                while (s.count(++num))
                {
                    conseq++;
                }

                longestSofar = max(longestSofar, conseq);
            }
        }

        return longestSofar;
    }
};
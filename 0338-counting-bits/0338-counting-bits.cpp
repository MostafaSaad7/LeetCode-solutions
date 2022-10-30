class Solution
{
public:
    vector<int> countBits(int n)
    {
        vector<int> res;
        for (int i = 0; i <= n; i++)
        {
            int ones = 0;
            int num = i;
            while (num > 0)
            {
                ones += num % 2;
                num = num / 2;
            }
            res.push_back(ones);
        }
        return res;
    }
};
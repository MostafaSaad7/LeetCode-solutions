class Solution
{
public:
    vector<bool> checkArithmeticSubarrays(vector<int> &nums, vector<int> &l, vector<int> &r)
    {
      vector<bool> ans;
        for (auto i = 0, j = 0; i < l.size(); ++i)
        {
            int left = l[i];
            int right = r[i];
            if (right - left < 2)
            {
                ans.push_back(true);
                continue;
            }
            int min = nums[left];
            int max = nums[left];
            for (int j = left; j <= right; j++)
            {
                if (nums[j] < min)
                    min = nums[j];
                if (nums[j] > max)
                    max = nums[j];
            }
            int len = r[i] - l[i] + 1, d = (max - min) / (len - 1);

            if (max == min)
                ans.push_back(true);
            else if ((max - min) % (len - 1))
                ans.push_back(false);
            else
            {
                vector<bool> n(len);
                for (j = l[i]; j <= r[i]; ++j)
                {
                    if ((nums[j] - min) % d || n[(nums[j] - min) / d])
                        break;
                    n[(nums[j] - min) / d] = true;
                }
                ans.push_back(j > r[i]);
            }
        }
        return ans;

    }
};

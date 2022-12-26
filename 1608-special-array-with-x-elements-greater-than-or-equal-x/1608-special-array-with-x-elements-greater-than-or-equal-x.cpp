class Solution
{
public:
    int specialArray(vector<int> &nums)
    {
        int n = nums.size();
        int l = 0, r = n;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++)
            {
                if (nums[i] >= mid)
                    cnt++;
            }
            if (cnt == mid)
                return mid;
            else if (cnt > mid)
                l = mid + 1;
            else
                r = mid-1;
        }
        return -1;
        
    }
};
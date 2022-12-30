int last_greater(vector<int> &v, int x)
{
    int l = 0, r = v.size() - 1;
    int ans = -1;
    while (l <= r)
    {
        int mid = (l + r) / 2;
        if (v[mid] >= x)
        {
            ans = mid;
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    return ans;
}
class Solution
{
public:
    int maxDistance(vector<int> &nums1, vector<int> &nums2)
    {

        int ans = 0;
        for (int i = 0; i < nums1.size(); i++)
        {
            int x = nums1[i];
            int idx = last_greater(nums2, x);
            if (idx != -1)
            {
                ans = max(ans, idx - i);
            }
        }
        return ans;
    }
};
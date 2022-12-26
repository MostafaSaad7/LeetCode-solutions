class Solution
{
public:
    int specialArray(vector<int> &nums)
    {
        //specialArray
        int n = nums.size();
        int count = 0;
        for (int i = 0; i <= n; i++)
        {
            count = 0;
            for (int j = 0; j < n; j++)
            {
                if (nums[j] >= i)
                    count++;
            }
            if (count == i)
                return i;
        }
        return -1;
        
    }
};

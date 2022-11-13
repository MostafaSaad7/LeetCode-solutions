class Solution
{
public:
    int searchInsert(vector<int> &nums, int target)
    {
        if (target > nums[nums.size() - 1])
            return nums.size();
        else if (target < nums[0])
            return 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }
};
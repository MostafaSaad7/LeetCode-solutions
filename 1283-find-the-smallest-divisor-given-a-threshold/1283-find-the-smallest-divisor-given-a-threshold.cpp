class Solution
{
public:
	bool fun(vector<int> &nums, int divisor, int thershold)
	{
		long long sum = 0;
		for (int &num : nums)
		{
			sum += (num + divisor - 1) / divisor;
			if (sum > thershold)
				return false;
		}
		return true;
	}
	int smallestDivisor(vector<int> &nums, int threshold)
	{
		int left = 1, right = *max_element(nums.begin(), nums.end());
		int divisor = right;

		while (left <= right)
		{
			long middle = left + (right - left) / 2;
			if (fun(nums, middle, threshold))
			{
				divisor = middle;
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		return divisor;
	}
};
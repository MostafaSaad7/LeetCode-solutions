class Solution {
public:
	int reductionOperations(vector<int> &nums) {
		sort(nums.rbegin(), nums.rend());	

		int operations = 0;
		for (int i = 1; i < (int)nums.size(); ++i)
			if (nums[i] != nums[i - 1])
				operations += i;

		return operations;
	}
};


class Solution {
public:
	vector<int> findRightInterval(vector<vector<int>> &interevals) {
		vector<vector<int>> startings;
		for (int i = 0; i < (int) interevals.size(); ++i)
			startings.push_back( { interevals[i][0], i });
		sort(startings.begin(), startings.end());	// sort on unique starts

		vector<int> ans(interevals.size(), -1);
		for (int i = 0; i < (int) interevals.size(); ++i) {
			vector<int> val { interevals[i][1], 0 };
			auto iter = lower_bound(startings.begin(), startings.end(), val);

			if (iter != startings.end()) {
				int idx = iter - startings.begin();
				ans[i] = startings[idx][1];
			}
		}
		return ans;
	}
};
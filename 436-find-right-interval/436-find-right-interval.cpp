class Solution {
public:
	vector<int> findRightInterval(vector<vector<int>> &intervals) {
		map<int, int> start_to_idx;
		for (int i = 0; i < (int) intervals.size(); i++)
			start_to_idx[intervals[i][0]] = i;
		
		vector<int> ans(intervals.size(), -1);

		for (int i = 0; i < (int) intervals.size(); i++) {
			auto iter = start_to_idx.lower_bound(intervals[i][1]);
			if (iter != start_to_idx.end())
				ans[i] = iter->second;
		}
		return ans;
	}
};
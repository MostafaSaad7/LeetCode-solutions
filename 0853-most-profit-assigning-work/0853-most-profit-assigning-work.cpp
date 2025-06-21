class Solution {
public:
	int maxProfitAssignment(vector<int> &diff, vector<int> &pro, vector<int> &worker) {
		vector<pair<int, int>> jobs;
		for (int i = 0; i < (int) diff.size(); i++)
			jobs.push_back( { diff[i], pro[i] });
		sort(worker.begin(), worker.end());
		sort(jobs.begin(), jobs.end());

		int job = 0, mxProfitSofar = 0, total_profit = 0;
		for (int i = 0; i < (int) worker.size(); i++) {
			for (; job < (int)jobs.size() && worker[i] >= jobs[job].first; ++job)
				mxProfitSofar = max(mxProfitSofar, jobs[job].second);

			total_profit += mxProfitSofar;
		}
		return total_profit;
	}
};
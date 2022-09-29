class Solution {
public:
   bool possible(vector<int> &houses, vector<int> heaters, int ridus) {
		int j = 0;
		for (int i = 0; i < (int) heaters.size(); ++i) {// O(N+M)
			int leftC = heaters[i] - ridus, rightC = heaters[i] + ridus;

			while (j < (int) houses.size() && leftC <= houses[j] && houses[j] <= rightC)
				++j;	
		}
		return j == (int) houses.size();	// all is covered?
	}
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        sort(houses.begin(), houses.end());
		sort(heaters.begin(), heaters.end());

		int start = 0, end = 1e9, radius = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (possible(houses, heaters, mid))	// find smallest
				end = mid - 1, radius = mid;
			else
				start = mid + 1;
		}
		return radius;
    }
};
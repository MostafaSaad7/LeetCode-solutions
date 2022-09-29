//dr mostafa saad
class Solution {
public:
	int findRadius(vector<int> &houses, vector<int> &heaters) {
		sort(heaters.begin(), heaters.end());
		int radius = INT_MIN;

		for (int i = 0; i < (int)houses.size(); i++) {
			int idx = lower_bound(heaters.begin(), heaters.end(), houses[i]) - heaters.begin();

			if(idx == (int)heaters.size())	// after heaters
				radius = max(radius, abs(heaters[idx - 1] - houses[i]));
			else if (idx == 0)				// before heaters
				radius = max(radius, abs(heaters[idx] - houses[i]));
			else {							// surrounded by heaters: comapr idx and idx-1
				int besti_r = min(abs(heaters[idx] - houses[i]), abs(heaters[idx - 1] - houses[i]));
				radius = max(radius, besti_r);
			}
		}
		return radius;
	}
};

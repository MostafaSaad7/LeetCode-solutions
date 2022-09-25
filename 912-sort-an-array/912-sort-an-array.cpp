
class Solution {
public:
	vector<int> sortArray(vector<int> &array) {
		int size = array.size();
		int mxVal = array[0], mnVal = array[0];

		for (int i = 1; i < size; ++i) {
			if (array[i] > mxVal)
				mxVal = array[i];
			if (array[i] < mnVal)
				mnVal = array[i];
		}
        int new_max = mxVal - mnVal;
		vector<int> count(new_max+1);

		for (int i = 0; i < size; ++i)
			count[array[i] - mnVal] += 1;

		int idx = 0;
		for (int i = 0; i <= new_max; ++i) {
			for (int j = 0; j < count[i]; ++j, ++idx)
				array[idx] = i + mnVal;
		}
		return array;
	}
};

//DR Mostafa Saad Ibrahim 
class Solution {
private:
	int collected = 0;

	// Add the keys attached to these boxes to available keys
	void addKeysFromBoxes(vector<int> &hasKey, vector<vector<int>> &keys, vector<int> &boxes) {
		for (int box : boxes)
			for (int key : keys[box])
				hasKey[key] = 1;
	}

	void openBoxes(queue<int> &q, vector<bool> &visited, vector<int> &hasKey, vector<int> &candies, vector<int> &boxes) {
		for(int box : boxes) {
			if (!visited[box] && hasKey[box]) {
				q.push(box);
				visited[box] = true;
				collected += candies[box];
			}
		}
	}
public:
	int maxCandies(vector<int> &hasKey, vector<int> &candies, vector<vector<int>> &keys, vector<vector<int>> &containedBoxes, vector<int> &initialBoxes) {
		queue<int> q;
		vector<bool> visited(hasKey.size());
		// Process the initial boxes: add keys and open more boxes
		addKeysFromBoxes(hasKey, keys, initialBoxes);
		openBoxes(q, visited, hasKey, candies, initialBoxes);	// multi-src

		while (!q.empty()) {
			int box = q.front();
			q.pop();
			addKeysFromBoxes(hasKey, keys, containedBoxes[box]);
			openBoxes(q, visited, hasKey, candies, containedBoxes[box]);
		}
		return collected;
	}
};
//DR mostafa saad's code 
typedef vector<vector<int>> GRAPH;

void add_directed_edge(GRAPH &graph, int from, int to) {
	graph[from].push_back(to);
}

int largestPathColor(const GRAPH &adjList, string &colors) {
	int sz = adjList.size();
	vector<int> indegree(sz, 0);
	for (int i = 0; i < sz; ++i)
		for (int j : adjList[i])
			indegree[j]++;

	queue<int> ready;
	for (int i = 0; i < sz; ++i)
		if (!indegree[i])
			ready.push(i);

	vector<vector<int>> mxColors(sz, vector<int>(26));	// n x 26: 26 colors per node
	int answer = 0, popped_nodes = 0;

	while (!ready.empty()) {
		int i = ready.front(), color = colors[i] - 'a';
		ready.pop();
		++mxColors[i][color];
		++popped_nodes;

		answer = max(answer, mxColors[i][color]);

		for (int j : adjList[i]) {
			if (--indegree[j] == 0)
				ready.push(j);
			// Update my neighbors that I can reach you with this set of colors frequencies
			for (int col = 0; col < 26; ++col)
				mxColors[j][col] = max(mxColors[j][col], mxColors[i][col]);
		}
	}
	if (popped_nodes != sz)
		return -1;
	return answer;
}

class Solution {
public:
	int largestPathValue(string colors, vector<vector<int>> &edges) {
		GRAPH graph(colors.size());

		for (auto &edge : edges)
			add_directed_edge(graph, edge[0], edge[1]);

		return largestPathColor(graph, colors);
	}
};
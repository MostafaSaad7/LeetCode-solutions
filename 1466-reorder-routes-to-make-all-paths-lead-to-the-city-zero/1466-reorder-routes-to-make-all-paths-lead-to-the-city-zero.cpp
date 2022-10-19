//DR Mostafa saad code 
struct edge {
	int to;
	bool built;
};

typedef vector<vector<edge>> GRAPH;

void add_undirected_edge(GRAPH &graph, int from, int to) {
	// Add the given edge and marked as built already.
	graph[from].push_back( { to, true });
	graph[to].push_back( { from, false });	// NOT built
}

void dfs(GRAPH &graph, int node, vector<bool> &visited, int &reorient_cnt) {
	visited[node] = true;

	for (edge &e : graph[node]) {
		if (!visited[e.to]) {
			reorient_cnt += e.built;	//
			dfs(graph, e.to, visited, reorient_cnt);
		}
	}
}

class Solution {
public:
	int minReorder(int nodes, vector<vector<int>> &connections) {
		int reorient_cnt = 0;
		GRAPH graph(nodes);
		vector<bool> visited(nodes);

		for (auto &edge : connections)
			add_undirected_edge(graph, edge[0], edge[1]);

		dfs(graph, 0, visited, reorient_cnt);
		return reorient_cnt;
	}
};

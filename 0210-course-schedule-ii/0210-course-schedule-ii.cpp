typedef vector<vector<int>> GRAPH;

void add_directed_edge(GRAPH &graph, int from, int to)
{
    graph[from].push_back(to);
}

bool dfs(GRAPH &graph, int node, unordered_set<int> &visited, unordered_set<int> &cycle, vector<int> &ordering)
{
    if (cycle.find(node) != cycle.end())
        return false;
    if (visited.find(node) != visited.end())
        return true;
    cycle.insert(node);
    for (int neighbour : graph[node])
    {
        if (!dfs(graph, neighbour, visited, cycle, ordering))
            return false; // cycle
    }
    cycle.erase(node);
    visited.insert(node);
    ordering.push_back(node);
    return true; // no cycle
}

vector<int> topological_sort(GRAPH &graph)
{
    int nodes = graph.size();

    vector<int> ordering;
    unordered_set<int> visited;
    unordered_set<int> cycle;

    for (int i = 0; i < nodes; ++i)
        if (visited.find(i) == visited.end()) // not visited
            if (!dfs(graph, i, visited, cycle, ordering))
                return vector<int>(); // cycle
    return ordering;
}

class Solution
{
public:
    vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites)
    {
        GRAPH graph(numCourses);
        for (auto &pair : prerequisites)
            add_directed_edge(graph, pair[0], pair[1]);

        return topological_sort(graph);
    }
};
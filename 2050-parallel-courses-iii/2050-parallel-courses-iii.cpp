typedef vector<vector<int>> GRAPH;

class Solution
{
    void add_directed_edge(GRAPH &graph, int from, int to)
    {
        graph[from].push_back(to);
    }

    int dfs(GRAPH &graph, vector<int> &time, int node, vector<int> &inDeg, vector<int> &mem)
    {

        if (mem[node] != 0)
            return mem[node];

        int res = 0;
        for (int n : graph[node])
        {
            res = max(res, dfs(graph, time, n, inDeg, mem));
        }

        mem[node] = res + time[node];
        return mem[node];
    }

public:
    int minimumTime(int n, vector<vector<int>> &relations, vector<int> &time)
    {
        vector<int> mem(n);
        GRAPH graph(n);
        for (auto &edge : relations)
            add_directed_edge(graph, edge[0] - 1, edge[1] - 1);
        vector<int> indegree(n, 0);
        for (int i = 0; i < n; ++i)
            for (int j : graph[i])
                indegree[j]++;
        int res = 0;
        for (int i = 0; i < n; ++i)
            if (indegree[i] == 0)
            {
                res = max(res, dfs(graph, time, i, indegree, mem));
            }
        return *max_element(begin(mem), end(mem));
    }
};

typedef vector<vector<int>> GRAPH;
class Solution
{
public:
    void addUndirectedEdge(GRAPH &graph, int from, int to)
    {
        graph[from].push_back(to);
        graph[to].push_back(-from);
    }
    int minReorder(int n, vector<vector<int>> &connections)
    {
        int result = 0;
        GRAPH graph(n);
        vector<bool> visited(n, 0);
        for (auto edge : connections)
        {
            addUndirectedEdge(graph, edge[0], edge[1]);
        }

        // from >> to 0
        DFS(graph, 0, visited, result);

        return result;
    }

    void DFS(GRAPH &graph, int cityToReach, vector<bool> &visited, int &result)
    {
        // if (visited[cityToReach])
        //     return;
        visited[cityToReach] = true;
        for (auto neighbours : graph[cityToReach])
        {
            if (!visited[abs(neighbours)])
            {
                if (neighbours > 0)
                    result++;
                DFS(graph, abs(neighbours), visited, result);
            }
        }
    }
};
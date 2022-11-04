typedef vector<vector<int>> GRAPH;
class Solution
{
public:
    void addEdge(GRAPH &adjList, int from, int to)
    {
        adjList[from].push_back(to);
        adjList[to].push_back(from);
    }

    vector<int> topSort(GRAPH &adjList)
    {
        int sz = adjList.size();

        if (sz == 1) // special case
            return {0};
        else if (sz == 2)
            return {0, 1};
        queue<int> q;
        vector<int> deg(adjList.size(), 0);
        for (auto node : adjList)
        {
            for (int neigbour : node)
            {
                deg[neigbour]++;
            }
        }

        for (int i = 0; i < deg.size(); i++)
        {
            if (deg[i] == 1)
                q.push(i);
        }
        vector<int> res;
        for (int sz = q.size(); !q.empty(); sz = q.size())
        {
            res.clear();
            while (sz--)
            {
                int node = q.front();
                q.pop();
                res.push_back(node);
                for (int neighbour : adjList[node])
                    if (--deg[neighbour] == 1)
                        q.push(neighbour);
            }
        }

        return res;
    }
    vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges)
    {
        GRAPH graph(edges.size() + 1);

        for (auto &edge : edges)
            addEdge(graph, edge[0], edge[1]);

        return topSort(graph);
    }
};
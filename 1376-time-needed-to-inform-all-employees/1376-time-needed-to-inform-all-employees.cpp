typedef unordered_map<int, vector<int>> GRAPH;

class Solution
{
public:
    void add_directed_edge(GRAPH &graph, int from, int to)
    {
        graph[from].push_back(to);
    }

    int numOfMinutes(int n, int headID, vector<int> &manager, vector<int> &informTime)
    {
        GRAPH graph(manager.size());
        for (int i = 0; i < manager.size(); i++)
        {
            if (!manager[i] != -1)
                add_directed_edge(graph, manager[i], i);
        }

        queue<pair<int, int>> q;
        int totalTime = 0;
        q.push({headID, informTime[headID]});
        for (int level = 0, sz = q.size(); !q.empty(); level++, sz = q.size())
        {
            while (sz--)
            {
                int node = q.front().first;
                int timeToReachNode = q.front().second;
                q.pop();
                totalTime = max(totalTime, timeToReachNode);
                for (auto i : graph[node])
                {
                    q.push({i, timeToReachNode + informTime[i]});
                }
            }
        }

        return totalTime;
    }
};
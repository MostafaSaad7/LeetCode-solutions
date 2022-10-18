class Solution
{
    vector<int> res;

public:
    vector<int> restoreArray(vector<vector<int>> &adjacentPairs)
    {
        unordered_map<int, vector<int>> graph;
        for (auto pair : adjacentPairs)
        {
            graph[pair[0]].push_back(pair[1]);
            graph[pair[1]].push_back(pair[0]);
        }

        unordered_set<int> visited;
        for (auto pair : graph)
        {
            if (pair.second.size() == 1)
            {
                DFS(graph, visited, pair.first);
                break;
            }
        }

        return res;
    }

    void DFS(unordered_map<int, vector<int>> &graph, unordered_set<int> &visited, int currentNode)
    {
        visited.insert(currentNode);
        res.push_back(currentNode);

        for (auto &neighbour : graph[currentNode])
        {

            if (visited.count(neighbour) != 0)
                continue;
            DFS(graph, visited, neighbour);
        }
    }
};
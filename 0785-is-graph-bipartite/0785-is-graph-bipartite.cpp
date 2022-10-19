class Solution
{
    bool contradiction{false};

public:
    void DFS(vector<vector<int>> &graph, vector<int> &colors, int node, int colorToAdd = 1)
    {
        if (colors[node] == 0)
            colors[node] = colorToAdd;
        else
        {
            if (colors[node] != colorToAdd)
            {
                contradiction = true;
            }

            return;
        }
        for (auto neighbour : graph[node])
        {
            DFS(graph, colors, neighbour, 3 - colorToAdd); // 3-1 = 2 ;   3-2 = 1 ;
        }
    }

    bool isBipartite(vector<vector<int>> &graph)
    {
        vector<int> colors(graph.size());

        // for CC
        for (int i = 0; i < graph.size(); i++)
        {
            if (colors[i] == 0)
                DFS(graph, colors, i);
            if (contradiction)
                return false;
        }

        return true;
    }
};

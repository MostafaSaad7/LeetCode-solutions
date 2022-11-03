typedef vector<vector<int>> GRAPH;

class Solution
{
public:
    void addDirectedEdge(GRAPH &adjList, int from, int to)
    {
        adjList[from].push_back(to);
    }

    bool topSort(GRAPH &adjList)
    {
        vector<int> inDeg(adjList.size(), 0);
        queue<int> q;
        vector<int> order;
        for (auto i : adjList)
        {
            for (int neighbour : i)
            {
                inDeg[neighbour]++;
            }
        }

        for (int i = 0; i < inDeg.size(); i++)
        {
            if (!inDeg[i])
                q.push(i);
        }

        while (!q.empty())
        {
            int node = q.front();
            q.pop();
            order.push_back(node);
            for (auto neihbour : adjList[node])
            {
                if (--inDeg[neihbour] == 0)
                    q.push(neihbour);
            }
        }

        if (order.size() != adjList.size())
            return false;
        return true;
    }
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        GRAPH adjList(numCourses);
        for (auto i : prerequisites)
        {
            addDirectedEdge(adjList, i[1], i[0]);
        }

        return topSort(adjList);
    }
};
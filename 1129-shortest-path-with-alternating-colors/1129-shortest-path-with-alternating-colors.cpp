typedef long long LL;
const int OO = 10000000; // A big value expressing infinity
const int RED = 0;
const int BLUE = 1;

struct edge
{
    int to;
    int color;
};

typedef vector<vector<edge>> GRAPH;

void add_directed_edge(GRAPH &graph, int from, int to, int color)
{
    graph[from].push_back({to, color});
}

vector<int> bfs(GRAPH &adjList, int start)
{
    int nodes = adjList.size();
    vector<int> answer(nodes, -1);
    vector<vector<int>> len(nodes, vector<int>(2, OO)); // N*2 grid
    queue<edge> q;

    q.push({start, RED});
    q.push({start, BLUE});
    len[start][RED] = len[start][BLUE] = 0;
    answer[start] = 0;

    for (int level = 0, sz = q.size(); !q.empty(); ++level, sz = q.size())
    {
        while (sz--)
        {
            int cur = q.front().to, color = q.front().color;
            q.pop();
            for (edge e : adjList[cur])
                if (color != e.color && len[e.to][e.color] == OO)
                {
                    q.push(e);
                    len[e.to][e.color] = level + 1;
                    if (answer[e.to] == -1) // we can reach the node from 2 colors. Keep the first only
                        answer[e.to] = level + 1;
                }
        }
    }
    return answer;
}

class Solution
{
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>> &red_edges, vector<vector<int>> &blue_edges)
    {
        GRAPH adjList(n);

        for (auto &e : red_edges)
            add_directed_edge(adjList, e[0], e[1], RED);

        for (auto &e : blue_edges)
            add_directed_edge(adjList, e[0], e[1], BLUE);

        return bfs(adjList, 0);
    }
};
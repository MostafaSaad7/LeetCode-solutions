// typedef vector<vector<int>> GRAPH;

// class Solution
// {
//     void add_directed_edge(GRAPH &graph, int from, int to)
//     {
//         graph[from].push_back(to);
//     }

//     int dfs(GRAPH &graph, vector<int> &time, int node, vector<int> &inDeg)
//     {
//         int res = 0;

//         if (graph[node].size() == 0)
//             return time[node];

//         for (int n : graph[node])
//         {
//             res = max(res, dfs(graph, time, n, inDeg));
//         }

//         return res + time[node];
//     }

// public:
//     int minimumTime(int n, vector<vector<int>> &relations, vector<int> &time)
//     {
//         GRAPH graph(n);

//         for (auto &edge : relations)
//             add_directed_edge(graph, edge[0] - 1, edge[1] - 1);
//         vector<int> indegree(n, 0);
//         for (int i = 0; i < n; ++i)
//             for (int j : graph[i])
//                 indegree[j]++;
//         int res = 0;
//         for (int i = 0; i < n; ++i)
//             if (indegree[i] == 0)
//             {
//                 res = max(res, dfs(graph, time, i, indegree));
//             }
//         return res;
//     }
// };

// solution from discussion 
// OJ: https://leetcode.com/problems/parallel-courses-iii/
// Author: github.com/lzl124631x
// Time: O(N + E)
// Space: O(N + E)
class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& E, vector<int>& T) {
        vector<vector<int>> G(n);
        vector<int> indegree(n), dist(n);
        for (auto &e : E) { // build graph and count indegrees
            G[e[0] - 1].push_back(e[1] - 1);
            indegree[e[1] - 1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) { // enqueue nodes with 0 indegree.
                q.push(i);
                dist[i] = T[i]; // source nodes' distance is their corresponding time
            } 
        }
        while (q.size()) {
            int u = q.front();
            q.pop();
            for (int v : G[u]) {
                dist[v] = max(dist[u] + T[v], dist[v]); // update the distance of node `v` using the maximum distance of predecessor nodes.
                if (--indegree[v] == 0) q.push(v); // enqueue node `v` when its indegree drops to 0
            }
        }
        return *max_element(begin(dist), end(dist)); // the answer is the maximum distance.
    }
};
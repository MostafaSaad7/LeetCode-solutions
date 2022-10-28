class Solution
{
public:
    int slidingPuzzle(vector<vector<int>> &board)
    {
        string goal = "123450";
        vector<vector<int>> dir{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {4, 2}};
        string startState = ""; 
        for (int i = 0; i < (int)board.size(); i++)
            for (int j = 0; j < (int)board[0].size(); j++)
                startState += board[i][j] + '0';
        if (goal == startState)
            return 0;
        unordered_set<string> visited;
        queue<string> q;
        q.push(startState);
        visited.insert(startState);
        for (int level = 0, sz = q.size(); !q.empty(); ++level, sz = q.size())
        {
            while (sz--)
            {
                string cur = q.front();
                q.pop();
                int idx1 = (int)cur.find('0');
                for (int idx2 : dir[idx1])
                {
                    swap(cur[idx1], cur[idx2]);

                    if (cur == goal)
                        return level + 1;

                    if (visited.insert(cur).second)
                        q.push(cur);
                    swap(cur[idx1], cur[idx2]); // undo
                }
            }
        }
        return -1;
    }
};
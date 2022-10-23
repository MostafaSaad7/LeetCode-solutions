class Solution
{
public:
    char next(char c)
    {
        if (c == '9')
            return '0';
        return c + 1;
    }

    char prev(char c)
    {
        if (c == '0')
            return '9';
        return c - 1;
    }
    bool validate(queue<string> &q, unordered_set<string> &visited, unordered_set<string> &deadendsSet, string value, string target)
    {
        if (target == value)
            return true;
        if (visited.count(value) == 0 && deadendsSet.count(value) == 0)
        {
            q.push(value);
            visited.insert(value);
        }
        return false;
    }
    int openLock(vector<string> &deadends, string target)
    {
        string start = "0000";
        if (start == target)
            return 0;
        unordered_set<string> deadendsSet(deadends.begin(), deadends.end());
        if (deadendsSet.count(start))
            return -1;
        queue<string> q;
        unordered_set<string> visited;
        q.push(start);
        visited.insert(start);

        for (int level = 0, sz = 1; !q.empty(); level++, sz = q.size())
        {
            while (sz--)
            {
                string value = q.front();
                q.pop();
                string copyS = value;
                for (int i = 0; i < 4; i++)
                {
                    value = copyS;
                    value[i] = next(value[i]);
                    if (validate(q, visited, deadendsSet, value, target))
                        return level + 1;
                    value = copyS;
                    value[i] = prev(value[i]);
                    if (validate(q, visited, deadendsSet, value, target))
                        return level + 1;
                }
            }
        }
        return -1;
    }
};
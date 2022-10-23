class Solution
{
    // Space >> 1001 element from 0 to 1000 >>> 1001 state let it be S
    // Time >> for each state do 3 operations for all array size let it n

    // total time = 3 * n * S >>>>>> O(n S)
public:
    bool validate(queue<int> &q, vector<bool> &visited, int value, int goal)
    {
        if (value == goal)
            return true;

        if (0 <= value && value <= 1000 && !visited[value])
        {
            q.push(value);
            visited[value] = true;
        }

        return false;
    }
    int minimumOperations(vector<int> &nums, int start, int goal)
    {
        vector<bool> visited(1001);
        queue<int> q;
        q.push(start);
        visited[start] = 1;

        for (int level = 0, sz = 1; !q.empty(); ++level, sz = q.size())
        {
            while (sz--)
            {
                int x = q.front();
                q.pop();
                for (int i = 0; i < (int)nums.size(); i++)
                    if (validate(q, visited, x + nums[i], goal) ||
                        validate(q, visited, x - nums[i], goal) ||
                        validate(q, visited, x ^ nums[i], goal))
                        return level + 1;
            }
        }
        return -1;
    }
};
class Solution
{
public:
    vector<int> dailyTemperatures(vector<int> &temperatures)
    {
        vector<int> result(temperatures.size(), 0);
        stack<int> stk;
        for (int i = 0; i < temperatures.size(); i++)
        {

            int num = temperatures[i];
            while (!stk.empty() && num > temperatures[stk.top()])
            {
                result[stk.top()] = (i - stk.top());
                stk.pop();
            }

            stk.push(i);
        }

        return result;
    }
};
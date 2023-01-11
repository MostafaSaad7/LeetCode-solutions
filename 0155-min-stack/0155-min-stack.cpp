class MinStack
{
private:
    stack<int> stk;
    stack<int> minstk;

public:
    MinStack()
    {
    }

    void push(int val)
    {
        stk.push(val);
        if (!minstk.empty() && minstk.top() <= val)
        {
            int minVal = minstk.top();
            minstk.push(minVal);
        }
        else
        {
            minstk.push(val);
        }
    }

    void pop()
    {
        if (!stk.empty())
        {
            minstk.pop();
            stk.pop();
        }
    }

    int top()
    {
        if (stk.top())
            return stk.top();
        return 0;
    }

    int getMin()
    {
        if (minstk.empty())
            return 0;
        int minVal = minstk.top();
        return minVal;
    }
};
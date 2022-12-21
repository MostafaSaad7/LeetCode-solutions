class Solution
{
public:
    int evalRPN(vector<string> &tokens)
    {
        stack<long> st;

        for (int i = 0; i < tokens.size(); i++)
        {
            if (tokens[i].size() == 1 && ispunct(tokens[i][0]))
            {
                long x = st.top();
                st.pop();
                long y = st.top();
                st.pop();
                if (tokens[i] == "+")
                    st.push(x + y);
                else if (tokens[i] == "-")
                    st.push(y - x);
                else if (tokens[i] == "*")
                    st.push(x * y);
                else if (tokens[i] == "/")
                    st.push(y / x);
            }
            else
            {
                long num = stoi(tokens[i]);
                st.push(num);
            }
        }

        return st.top();
    }
};
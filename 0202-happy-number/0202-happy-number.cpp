class Solution
{
public:
    bool isHappy(int n)
    {
        unordered_set<int> st;
        while (!st.count(n))
        {
            st.insert(n);
            int newNum = 0;
            while (n > 0)
            {
                newNum += pow((n % 10), 2);
                n = n / 10;
            }
            n = newNum;
        }
        return n == 1;
    }
};
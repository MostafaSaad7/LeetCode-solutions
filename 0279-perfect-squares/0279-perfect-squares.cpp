const int MAX = 1e4 + 5;
int memory[MAX];
class Solution
{
public:
    int perfectSquares(int n)
    {
        if (n <= 0)
            return 0;

        auto &ret = memory[n];
        if (ret != -1)
            return ret;

        ret = n;
        for (int i = 1; i < n; ++i)
        {
            if (i * i > n)
                break;
            ret = min(ret, 1 + perfectSquares(n - i * i));
        }
        return ret;
    }
    int numSquares(int n)
    {
        memset(memory, -1, sizeof(memory));
        return perfectSquares(n);
    }
};

const int MAX = 500 + 5;
int memory[MAX][MAX];
string w1;
string w2;
class Solution
{
public:
    int dp(int index1 = 0, int index2 = 0)
    {
        if (index1 == w1.size())
        {
            return w2.size() - index2;
        }
        if (index2 == w2.size())
        {
            return w1.size() - index1;
        }
        int &ret = memory[index1][index2];
        if (ret != -1)
            return ret;

        if (w1[index1] == w2[index2])
            return ret = dp(index1 + 1, index2 + 1);
        int del = 1 + dp(index1 + 1, index2);
        del=min(del,1+dp(index1,index2+1));
        int change = 1 + dp(index1 + 1, index2 + 1);
        int insert = 1 + dp(index1, index2 + 1);
        insert=min(insert,1+dp(index1+1,index2));

        return ret = min({del, change, insert});
    }
    int minDistance(string word1, string word2)
    {
        w1 = word1;
        w2 = word2;
        memset(memory, -1, sizeof(memory));
        return dp(0, 0);
    }
};
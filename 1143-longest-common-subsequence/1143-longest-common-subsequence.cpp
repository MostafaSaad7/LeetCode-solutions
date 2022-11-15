const int MAX = 1000 + 1;
int memory[MAX][MAX];
string s1;
string s2;

class Solution
{
public:
    int dp(int idx1, int idx2)
    {
        if (idx1 == s1.size() || idx2 == s2.size())
            return 0;
        int &ref = memory[idx1][idx2];
        if (ref != -1)
            return ref;
        ref = 0;
        int c1 = 0;
        int c2 = 0;
        if (s1[idx1] == s2[idx2])
            c1 = 1 + dp(idx1 + 1, idx2 + 1);
        else
        {
            c2 = max(dp(idx1 + 1, idx2), dp(idx1, idx2 + 1));
        }

        return ref = max(c1, c2);
    }
    int longestCommonSubsequence(string text1, string text2)
    {
        s1 = text1;
        s2 = text2;
        memset(memory, -1, sizeof(memory));
        return dp(0, 0);
    }
};
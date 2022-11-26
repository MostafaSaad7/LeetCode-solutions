//dr mostafa saad
const int MAX = 1001 + 1;
short memory[MAX][MAX]; // values only -1, 0, 1. We can represent in other ways
string str;
class Solution
{
    int isPalindrome(int start, int end)
    {                     // O(n^2)
        if (start >= end) // range is done
            return 1;     // single letter or empty string are palindromes

        auto &ret = memory[start][end];
        if (ret != -1)
            return ret;

        if (str[start] == str[end])
            return ret = isPalindrome(start + 1, end - 1);

        return ret = 0;
    }

public:
    string longestPalindrome(string s)
    {
        str = s;
        memset(memory, -1, sizeof(memory));

        int idx = -1, length = 0, sz = (int)s.size();

        // Try all ranges and pick the longest
        // Think in any recursive call as O(1)
        // So this 2 nested are O(n^2)
        for (int i = 0; i < sz; ++i)
        {
            for (int j = i; j < sz; ++j)
            {
                if (isPalindrome(i, j) && (j - i + 1) > length)
                    idx = i, length = j - i + 1;
            }
        }
        return s.substr(idx, length);
    }
};
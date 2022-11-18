class Solution
{
public:
    bool isPalindrome(string s)
    {
        int left = 0;
        int right = s.size() - 1;
        while (left <= right)
        {
            char leftC = s[left];
            char rightC = s[right];
            if (!(isdigit(leftC) || isalpha(leftC)))
                left++;
            else if (!(isdigit(rightC) || isalpha(rightC)))
                right--;
            else
            {
                if (tolower(leftC) == tolower(rightC))
                {
                    left++;
                    right--;
                }
                else
                    return false;
            }
        }

        return true;
    }
};
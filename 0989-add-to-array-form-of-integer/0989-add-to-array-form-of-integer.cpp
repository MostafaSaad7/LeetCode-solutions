class Solution
{
public:
    vector<int> addToArrayForm(const vector<int> &num, int k)
    {
        string str = to_string(k);
        int p1 = num.size() - 1;
        int p2 = str.size() - 1;
        vector<int> result;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0)
        {
            int num1 = 0;
            int num2 = 0;
            if (p1 >= 0)
            {
                num1 = num[p1--];
            }

            if (p2 >= 0)
            {
                num2 = str[p2--] - '0';
            }

            int addition = num1 + num2 + carry;

            result.push_back((addition % 10));
            carry = addition / 10;
        }
        if (carry != 0)
            result.push_back(carry);

        reverse(result.begin(), result.end());
        return result;
    }
};
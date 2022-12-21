class Solution
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        int lastElement = digits.size() - 1;
        int carry = 1;
        for (int i = lastElement; i > -1; i--)
        {
            int res = digits[i] +carry;
            carry = res / 10;
            res = res % 10;
            digits[i] = res;
            if (carry == 0)
                return digits;
        }

        vector<int> v(digits.size() + 1);
        v[0] = carry;
        for (int i = 1; i < digits.size(); i++)
        {
            v[i] = digits[i - 1];
        }

        return v;
    }
};
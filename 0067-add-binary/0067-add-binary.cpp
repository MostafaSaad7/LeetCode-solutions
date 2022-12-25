class Solution
{
public:
    string addBinary(string a, string b)
    {
        string result = "";
        int p1 = a.size() - 1;
        int p2 = b.size() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0)
        {
            int bit1 = 0;
            int bit2 = 0;

            if (p1 >= 0)
                bit1 = a[p1--] - '0';

            if (p2 >= 0)
                bit2 = b[p2--] - '0';
            int addition = bit1 + bit2 + carry;
            int res = addition % 2;
            carry = addition / 2;
            result += res + '0';
        }
        result += carry + '0';
        reverse(result.begin(), result.end());
        int firstOne = result.find_first_of('1');
        if (firstOne == -1)
            return "0";
        return result.substr(firstOne);
    }
};
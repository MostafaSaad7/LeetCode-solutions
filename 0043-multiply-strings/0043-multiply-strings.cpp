class Solution
{
public:
    string multiply(string num1, string num2)
    {
        string result(num1.size() + num2.size(), '0');

        for (int i = (int)num1.size() - 1; i >= 0; i--)
        {
            int carry = 0;
            for (int j = (int)num2.size() - 1; j >= 0; j--)
            {
            int mul = (result[i + j + 1] - '0') + (num1[i] - '0') * (num2[j] - '0') + carry;

                carry = mul / 10;
                int mulRes = mul % 10;
                result[i + j + 1] = mulRes+'0';
            }
            result[i] += carry;
        }

        for(int i = 0 ; i < result.size();i++)
        {
            if(result[i]!='0')
                return result.substr(i);
        }
        return "0";
    }
};
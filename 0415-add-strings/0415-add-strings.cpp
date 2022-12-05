class Solution
{
public:
    string addStrings(string num1, string num2)
    {
        int carry = 0;
        int p1 = 0;
        int p2 = 0;
        string result = "";
        while (p1 < num1.size() || p2 < num2.size())
        {

            int sum=carry;
            if (p1 < (int)num1.size())
                sum+=num1[num1.size() - 1 - p1] - '0';
            if (p2 < (int)num2.size())
                sum+=num2[num2.size() - 1 - p2] - '0';

    
            carry = sum / 10;
            int resNum = sum % 10;
            result += '0' + resNum;
            p1++;
            p2++;
        }

        if (carry)
            result += '0' + carry;

        reverse(result.begin(), result.end());
        return result;
    }
};
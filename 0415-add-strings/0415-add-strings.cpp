class Solution
{
public:
    string addStrings(string num1, string num2)
    {
        int carry = 0;
        int p1 = num1.size()-1;
        int p2 = num2.size()-1;
        string result = "";
        while (p1 >=0 || p2 >=0 || carry)
        {

            int sum=carry;
            if (p1 >=0)
                sum+=num1[p1] - '0';
            if (p2 >=0)
                sum+=num2[p2] - '0';

    
            carry = sum / 10;
            int resNum = sum % 10;
            result += '0' + resNum;
            p1--;
            p2--;
        }

        reverse(result.begin(), result.end());
        return result;
    }
};
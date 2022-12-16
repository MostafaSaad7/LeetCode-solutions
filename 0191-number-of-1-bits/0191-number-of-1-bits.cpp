class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        int ones = 0;
        for (;n;)
        {
            n =n&(n-1);
            ones+=1;
        }
        return ones;
    }
};
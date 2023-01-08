class Solution
{
public:
    int nextGreaterElement(int n)
    {
        long m = n;
        vector<int> nums(10, 0);
        int rem = -1;
        int prevRem = -1;
        while (m > 0)
        {
            rem = m % 10;
            m = m / 10;
            nums[rem]++;
            if (prevRem > rem)
            {
                // that's the pos to stop and choose the max num above Rem
                int nextGreaterNum = rem + 1;
                while (nums[nextGreaterNum] == 0)
                {
                    nextGreaterNum++;
                }
                nums[nextGreaterNum]--;
                m = m * 10 + nextGreaterNum;

                for (int i = 0; i < 10; i++)
                {
                    while (nums[i] != 0)
                    {
                        nums[i]--;
                        m = m * 10 + i;
                    }
                }

                return m > INT_MAX ? -1 : m;
            }
            prevRem = rem;
        }

        return -1;
    }
};
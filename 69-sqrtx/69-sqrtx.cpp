class Solution
{
public:
    double fun(double val)
    {
        return val * val;
    }
    int mySqrt(int x)
    {
        double left = 0, right = x, mid = 0;
        for (int i = 0; i < 100 ; i++)
        {
            mid = left + (right - left) / 2;

            if (fun(mid) > x)
                right = mid;
            else
                left = mid;
        }

        return (int)(mid + 1e-9);
    }
};
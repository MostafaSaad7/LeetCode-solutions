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
        while (fabs(left - right) > 1e-9)
        {
            mid =( left + right  ) / 2;

            if (fun(mid) > x)
                right = mid;
            else
                left = mid;
        }

        return (int)(mid + 1e-9);
    }
};
class Solution
{
public:
    int mySqrt(int x)
    {
        double left = 0, right = x, mid=0;
        while  (fabs(left- right)>1e-9)
        {
             mid = left + (right - left) / 2;
            
             if ((mid * mid) > x)
                right = mid;
            else
                left = mid;
        }

        return (int) (mid+1e-9);
    }
};
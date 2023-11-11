/*
    The purpose is to find the greatest number where it's multiplication by itself id lesser than or equal x
 */
class Solution {
       double fun(double val)
    {
        return val * val;
    }
    public int mySqrt(int x) {
       double left = 0, right = x, mid = 0;
        for (int i = 0; i < 100 ; i++)
        {
            mid = left + (right - left) / 2;

            if (fun(mid) > x)
                right = mid;
            else
                left = mid;
        }

        return (int)(mid);
    }
}
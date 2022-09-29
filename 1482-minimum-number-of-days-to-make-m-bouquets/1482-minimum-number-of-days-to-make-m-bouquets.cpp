
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <cmath>
#include <iomanip>
using namespace std;
class Solution
{
public:
    bool fun(vector<int> &bloomDay, int m, int k, int days)
    {
        int boq = 0;
        int adj = 0;
        for (int i = 0; i < (int)bloomDay.size(); ++i)
        {
            if (bloomDay[i] <= days)
            {
                ++adj;

                if (adj >= k)
                    adj = 0, ++boq;

                if (boq == m) // done
                    return true;
            }
            else
                adj = 0;
        }
        return false;
    }
    int minDays(vector<int> &bloomDay, int m, int k)
    {
        if (m > (int)bloomDay.size()/k )
            return -1;
        int start = 1, end = *max_element(bloomDay.begin(), bloomDay.end());
        int res = -1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (fun(bloomDay, m, k, mid))
                end = mid - 1, res = mid;
            else
                start = mid + 1;
        }
        return res;
    }
};
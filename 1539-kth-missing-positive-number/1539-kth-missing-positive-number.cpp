class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int left= 0;
        int right= arr.size()-1;
        while(left<=right)
        {
            int mid= left+(right-left)/2;
            int missing = fun(arr[mid],mid+1);
            if(missing >= k )
            right = mid-1;
            else
                left = mid+1;
            
        }
        if(right ==-1 )
            return k;
        return arr[right]+k-fun(arr[right],right+1);
    }
    int fun(int x,int y )
    {
        return x-y;
    }
};
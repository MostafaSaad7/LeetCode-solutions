/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        int ans = -1 ;
        int min = 1;
        int max = n ;
        while(min<=max )
        {
            int mid = min+(max-min)/2;
            int guessRes = guess(mid);
            if(guessRes ==0 )
            {
                ans=mid;
                break;
            }
            else if (guessRes == -1 )
                max=mid-1;
            else
                min=mid+1;
            
        }
        
        return ans;
    }
};
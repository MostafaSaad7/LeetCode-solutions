import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         * nums[i] == nums[j] and abs(i - j) <= k.
         *
         * */
        HashSet<Integer> windowElement= new HashSet<>(); // this set will be used to put window elements

        for (int i = 0; i < nums.length; i++) {
            if (i>k) windowElement.remove(nums[i-k-1]); // i - (k-1) ==> window start 
            //(k-1) ==> is zero based
            if (windowElement.contains(nums[i]))
                return true;
            windowElement.add(nums[i]);
        }
        return false;
    }
}
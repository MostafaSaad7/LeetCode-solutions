import java.util.Arrays;
import java.util.List;

class Solution {
    public static int missingNumber(int[] nums) {




        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += (i - nums[i]);
        }
        return sum;

    }

    public static int missingNumberSol2(int[] nums) {


        /*
         *
         * Xor two similar number return 0
         * Xor 0 with any number return this number
         * */

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;

    }

    public static int missingNumberSol1(int[] nums) {


        /*
         * eg :
         * nums [0,2,3,4,5] -- nums sum =14
         * elements for 0--->5
         * sum=15
         * res = sum- nums sum = 15-14=1
         *
         *
         * */
        int n = nums.length;
        int sum = ((n + 1) * (n)) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }


}
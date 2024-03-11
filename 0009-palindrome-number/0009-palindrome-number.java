class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long dividend = 1;
        //x > dividend*10 the mean of this condition is do we need any other zero to be added to dividend
        while (x >= dividend * 10) {
            dividend *= 10;
        }
        while (x != 0) {

            if (x % 10 != x / dividend)
                return false;
            x = (int) (x % dividend); // to remove left digit eg: 1221 % 1000 ---> 221
            x = (x / 10); // to remove right digit
            dividend /= 100; // because we removed 2 numbers 1 from the left and one from the rigt
        }
        return true;
    }}
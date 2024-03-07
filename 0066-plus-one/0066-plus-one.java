class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for(int i = digits.length-1 ; i >=0;i--)
        {
            int  tempResult = digits[i]+carry;
            digits[i]=tempResult%10;
            carry=tempResult/10;
            if(carry==0)
            return digits;
        }
        if(carry!=0)
        {
            int tempArr[] =new int[digits.length+1];
            int i =tempArr.length-1;
            for( ; i >0;i--)
            {
                tempArr[i]=digits[i-1];
            }
            tempArr[i]=carry;
            return tempArr;
        }

        return digits;
    }
}
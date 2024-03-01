class Solution {
    public String maximumOddBinaryNumber(String s) {

        int length = s.length(); // Specify the desired length
        int ones = 0;
        StringBuilder result = new StringBuilder(s);
        int nextOnePlace = 0 ;

        for (int i = 0; i < s.length(); i++)
        {
            if (result.charAt(i)=='1')
            {
                result.setCharAt(i,result.charAt(nextOnePlace));
                result.setCharAt(nextOnePlace++,'1');
            }



        }

        
        char temp = result.charAt(length-1);
        

        result.setCharAt(length-1,result.charAt(nextOnePlace-1));
        result.setCharAt(nextOnePlace-1,temp);

        return result.toString();
    }
}
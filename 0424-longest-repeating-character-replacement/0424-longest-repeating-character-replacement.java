class Solution {
    public int characterReplacement(String s, int k) {

        int ans = 0;
        int maxOccElemSoFar = 0;
        int[] countArr = new int[26];
        for (int right = 0, left = 0; right < s.length(); right++) {
            maxOccElemSoFar = Math.max(maxOccElemSoFar, ++countArr[s.charAt(right)- 'A']);

   

            /*
            *
            * maxOccElemSoFar not updated correctly since it will not affect the ans except it has greater value
            * 
            *  right - left + 1 ---> window len 
            * */
            if ( right - left + 1 - maxOccElemSoFar > k) {
                countArr[s.charAt(left)- 'A']--;
                left++;
            }

            ans = Math.max(ans,  right - left + 1);
        }

        return ans;
    }
}
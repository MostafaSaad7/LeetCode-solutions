import java.util.HashSet;

class Solution {


    /*
            Input: s = "pw wkew"
            Output: 3
            Explanation: The answer is "wke", with the length of 3.
            Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


            "dvdf"
    * */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int right = 0, left = 0; right < s.length();) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right++));
                res = Math.max(res, hashSet.size());
            } else {
                    hashSet.remove(s.charAt(left));
                    left++;
                }



        }
        return res;
    }
}
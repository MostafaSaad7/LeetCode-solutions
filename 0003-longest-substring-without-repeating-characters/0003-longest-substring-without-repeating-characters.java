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
        int left = 0;
        int right = 0;
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right++));
                            res = Math.max(res, hashSet.size());
            } else {
                hashSet.remove(s.charAt(left));
                left++;
            }


        }
        res = Math.max(res, hashSet.size());
        return res;
    }
}
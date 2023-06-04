class Solution {
    public boolean isAnagram(String s, String t) {
        int alpha [] = new int[26];
        Arrays.fill(alpha,0);
        if(t.length()!=s.length())
            return false;
        for(int i =0 ;i < t.length();i++)
        {
            alpha[t.charAt(i)-'a']++;
        }

        for(int i = 0; i < s.length(); i++)
            if(--alpha[s.charAt(i)-'a'] <0 )
                return false;
        return true;
    }
}
class Solution {

    // O(n m )  ---> n first string size and m is number of strings in strs array 
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1)
            return strs[0];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) return res.toString();
            }

            res.append(strs[0].charAt(i));
        }

        return res.toString();

    }
}
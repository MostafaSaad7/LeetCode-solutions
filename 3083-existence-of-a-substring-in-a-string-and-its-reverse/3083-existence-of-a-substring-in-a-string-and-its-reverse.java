import java.util.HashSet;

class Solution {
    public boolean isSubstringPresent(String s) {

        if (s.length() == 1)
            return false;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            hashSet.add(s.substring(i, i + 2));
        }
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        for (int i = 0; i < s.length() - 1; i++) {
            if (hashSet.contains(stringBuilder.substring(i, i + 2))) return true;
        }

        return false;
    }
}
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, new HashSet<>(), s);
    }

    int backtrack(int index, Set<String> seen, String s) {
        if (index == s.length()) {
            return 0;
        }

        int maxUniqueSplits = 0;
        for (int end = index + 1; end <= s.length(); end++) {
            String currentString = s.substring(index, end);

            if (seen.contains(currentString)) {
                continue;
            }
            seen.add(currentString);
            maxUniqueSplits = Math.max(maxUniqueSplits, 1 + backtrack(end, seen, s));
            seen.remove(currentString);
        }

        return maxUniqueSplits;
    }
}

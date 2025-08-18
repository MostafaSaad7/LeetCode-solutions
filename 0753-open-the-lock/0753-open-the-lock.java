import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        // Deadends set for quick lookup
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        // If start or target is dead -> impossible
        if (dead.contains("0000")) return -1;

        // BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // Visited set
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                String cur = queue.poll();

                // Found the target
                if (cur.equals(target)) return steps;

                // Skip if deadend
                if (dead.contains(cur)) continue;

                // Generate neighbors
                for (String next : getNeighbors(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // Generate all 8 neighbors by turning each wheel +1 or -1
    private List<String> getNeighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = arr[i];

            // +1
            arr[i] = (c == '9') ? '0' : (char)(c + 1);
            res.add(new String(arr));

            // -1
            arr[i] = (c == '0') ? '9' : (char)(c - 1);
            res.add(new String(arr));

            // restore
            arr[i] = c;
        }
        return res;
    }
}

/*
----------------------------
Time Complexity:
----------------------------
- There are at most 10,000 possible states ("0000" .. "9999").
- Each state generates 8 neighbors.
- BFS visits each state at most once.
- So: O(10,000 * 8) = O(10^4).

----------------------------
Space Complexity:
----------------------------
- Queue can hold up to O(10,000) states.
- Visited set holds at most 10,000 states.
- Deadends set adds up to O(d), where d = deadends.length.
- So total = O(10,000 + d).
*/

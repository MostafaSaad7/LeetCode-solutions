import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1001]; // visited states in [0..1000]
        
        queue.add(start);
        if (0 <= start && start <= 1000) {
            visited[start] = true;
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int num = queue.poll();

                if (num == goal) return level;

                for (int x : nums) {
                    int[] neighbors = {num + x, num - x, num ^ x};
                    for (int neighbor : neighbors) {
                        if (neighbor == goal) return level + 1;
                        if (isValid(neighbor) && !visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    boolean isValid(int num) {
        return 0 <= num && num <= 1000;
    }
}

/*
----------------------------
 Time Complexity:
----------------------------
- Each state (number in range [0..1000]) can be visited at most once → O(1001).
- For each state, we try 3 operations (+, -, ^) for each element in nums → O(3 * n).
- So worst case = O(1000 * n), where n = nums.length.

----------------------------
 Space Complexity:
----------------------------
- Queue can hold at most all states in [0..1000] → O(1000).
- Visited array → O(1001).
- Constant overhead for neighbors array → O(1).
- Total = O(1000 + 1001) = O(1000), which is effectively O(1) bounded space.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] DIR = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Populate the queue with the initial rotten oranges and count the fresh ones
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, no time is needed
        if (freshCount == 0) return 0;

        int time = 0;
        // Step 2: BFS to rot the fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyFreshTurnedRotten = false;

            // Process all the rotten oranges at the current level
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                // Check all four possible directions
                for (int[] direction : DIR) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    // Skip if out of bounds or the cell is not a fresh orange
                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != 1) {
                        continue;
                    }

                    // This fresh orange will now become rotten
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;
                    anyFreshTurnedRotten = true; // Mark that a fresh orange turned rotten
                }
            }

            // Increment time only if any fresh oranges turned rotten during this level
            if (anyFreshTurnedRotten) {
                time++;
            }
        }

        // If there are still fresh oranges left, return -1
        return freshCount == 0 ? time : -1;
    }
}

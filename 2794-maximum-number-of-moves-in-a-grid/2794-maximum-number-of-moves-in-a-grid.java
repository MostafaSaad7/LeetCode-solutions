import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dirs = {-1, 0, 1};

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[M][N];

        // Enqueue the cells in the first column.
        for (int i = 0; i < M; i++) {
            vis[i][0] = true;
            q.offer(new int[]{i, 0});
        }

        int levels = -1;
        while (!q.isEmpty()) {
            levels++;
            int sz = q.size();
            while (sz-- > 0) {
                int[] v = q.poll();

                // Current cell with the number of moves made so far.
                int row = v[0], col = v[1];

                for (int dir : dirs) {
                    // Next cell after the move.
                    int newRow = row + dir, newCol = col + 1;

                    // If the next cell isn't visited yet and is greater than
                    // the current cell value, add it to the queue with the
                    // incremented move count.
                    if (
                            newRow >= 0 &&
                                    newCol >= 0 &&
                                    newRow < M &&
                                    newCol < N &&
                                    !vis[newRow][newCol] &&
                                    grid[row][col] < grid[newRow][newCol]
                    ) {
                        vis[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return levels == -1 ? 0 : levels;
    }
}
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    final int INF = (int) 1e9;
    final int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean isValid(int r, int c, int[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int r = current[0];
            int c = current[1];

            for (int d = 0; d < 4; ++d) {
                int newRow = r + DIR[d][0];
                int newCol = c + DIR[d][1];

                int edgeWeight = (d != (grid[r][c] - 1)) ? 1 : 0;
                int newDist = dist[r][c] + edgeWeight;

                if (!isValid(newRow, newCol, grid) || newDist >= dist[newRow][newCol]) {
                    continue;
                }
                
                dist[newRow][newCol] = newDist;
                
                if (edgeWeight == 0) {
                    deque.addFirst(new int[]{newRow, newCol});
                } else {
                    deque.addLast(new int[]{newRow, newCol});
                }
                
            }
        }
        return dist[rows - 1][cols - 1];
    }
}
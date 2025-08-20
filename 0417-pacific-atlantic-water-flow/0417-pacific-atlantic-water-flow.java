import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length;
        final int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < COLS; i++) {
            pacificQueue.add(new int[]{0, i});
            atlanticQueue.add(new int[]{ROWS - 1, i});
        }

        for (int i = 0; i < ROWS; i++) {
            pacificQueue.add(new int[]{i, 0});
            atlanticQueue.add(new int[]{i, COLS - 1});
        }

        bfs(pacificQueue, pacific, heights);
        bfs(atlanticQueue, atlantic, heights);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] ocean, int[][] heights) {
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            int row = poll[0];
            int col = poll[1];

            ocean[row][col] = true;

            for (int[] dir : DIRS) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if (valid(nRow, nCol, ocean) && !ocean[nRow][nCol] && heights[nRow][nCol] >= heights[row][col]) {
                    queue.add(new int[]{nRow, nCol});
                }

            }
        }
    }

    private boolean valid(int nRow, int nCol, boolean[][] ocean) {
        return nRow >= 0 && nRow < ocean.length && nCol >= 0 && nCol < ocean[0].length;
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] inDegree = new int[rows][cols];
        calculateInDegree(matrix, inDegree);
        return bfs(matrix, inDegree);
    }


    void calculateInDegree(int[][] matrix, int[][] inDegree) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                        inDegree[nr][nc]++;
                    }
                }
            }
        }
    }

    int bfs(int[][] matrix, int[][] inDegree) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (inDegree[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                        inDegree[nr][nc]--;
                        if (inDegree[nr][nc] == 0) {
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            levels++;

        }
        return levels;
    }
}
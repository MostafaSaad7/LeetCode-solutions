import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] DIR = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int time = 0;
        while (!queue.isEmpty() && freshCount != 0) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] direction : DIR) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;
                }
            }


                time++;
        
        }

        return freshCount == 0 ? time : -1;
    }
}

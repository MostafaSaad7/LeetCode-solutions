import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        // Initialize queues with the borders
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }
        // Perform BFS for both oceans
        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);
        // Collect results
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int m = heights.length, n = heights[0].length;
        int[] directions = {-1, 0, 1, 0, -1}; // Up, Right, Down, Left
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i];
                int newY = y + directions[i + 1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                    !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }
}

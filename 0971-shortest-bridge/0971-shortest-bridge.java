import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Find the first island and mark all its cells
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j, n);
                    found = true;
                }
            }
        }
        
        // BFS to find the shortest path to the second island
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    
                    if (isValid(x, y, n) && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            // Found the second island
                            return steps;
                        }
                        // Mark water cell as visited and add to queue
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        
        return -1; // Should never reach here for valid input
    }
    
    // DFS to find all cells of the first island
    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int i, int j, int n) {
        if (!isValid(i, j, n) || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        
        // Explore all 4 directions
        for (int[] d : dir) {
            dfs(grid, visited, queue, i + d[0], j + d[1], n);
        }
    }
    
    boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
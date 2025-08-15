class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        return binarySearch(heights);
    }

    int binarySearch(int[][] heights) {
        int left = 0;
        int right = 1_000_000; // max possible height difference
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(heights, mid)) {
                result = mid;
                right = mid - 1; // try smaller effort
            } else {
                left = mid + 1; // need bigger effort
            }
        }
        return result;
    }

    boolean possible(int[][] heights, int limit) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        return dfs(heights, 0, 0, limit, visited);
    }

    boolean dfs(int[][] heights, int row, int col, int limit, boolean[][] visited) {
        visited[row][col] = true;
        if (row == heights.length - 1 && col == heights[0].length - 1) {
            return true;
        }

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(heights, row, col, newRow, newCol, limit, visited)) {
                if (dfs(heights, newRow, newCol, limit, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isValid(int[][] heights, int row, int col, int newRow, int newCol,
                    int limit, boolean[][] visited) {
        return newRow >= 0 && newRow < heights.length &&
               newCol >= 0 && newCol < heights[0].length &&
               !visited[newRow][newCol] &&
               Math.abs(heights[newRow][newCol] - heights[row][col]) <= limit;
    }
}

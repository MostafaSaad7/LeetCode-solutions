class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        return binarySearch(heights);
    }

    int binarySearch(int[][] heights) {
        int left = 0;
        int right = 1_000_000;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(heights, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    boolean possible(int[][] heights, int limit) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        return dfs(heights, 0, 0, limit, visited, heights[0][0]);
    }

    boolean dfs(int[][] heights, int row, int col, int limit, boolean[][] visited, int prevHeight) {
        if (!isValid(heights, row, col) || visited[row][col] ||
            Math.abs(heights[row][col] - prevHeight) > limit) {
            return false;
        }

        visited[row][col] = true;

        if (row == heights.length - 1 && col == heights[0].length - 1) {
            return true;
        }

        for (int[] dir : directions) {
            if (dfs(heights, row + dir[0], col + dir[1], limit, visited, heights[row][col])) {
                return true;
            }
        }
        return false;
    }

    boolean isValid(int[][] heights, int r, int c) {
        return r >= 0 && c >= 0 && r < heights.length && c < heights[0].length;
    }
}

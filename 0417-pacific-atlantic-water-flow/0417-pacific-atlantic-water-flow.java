import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<>();

        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, visitedPacific, -1, 0, col);
            dfs(heights, visitedAtlantic, -1, heights.length - 1, col);
        }
        for (int row = 0; row < heights.length; row++) {
            dfs(heights, visitedPacific, -1, row, 0);
            dfs(heights, visitedAtlantic, -1, row, heights[0].length-1);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j])
                    res.add(List.of(i, j));
            }
        }
        return res;
    }

    void dfs(int[][] heights, boolean[][] visited, int prevNodeHeight, int row, int col) {
        if (!isValid(heights, row, col) || visited[row][col] || prevNodeHeight > heights[row][col]) return;

        visited[row][col] = true;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (!isValid(heights, newRow, newCol) || visited[newRow][newCol])
                continue;
            dfs(heights, visited, heights[row][col], newRow, newCol);
        }


    }


    boolean isValid(int[][] heights, int row, int col) {
        if (row >= heights.length || row < 0) {
            return false;
        } else return col >= 0 && col < heights[row].length;
    }
}
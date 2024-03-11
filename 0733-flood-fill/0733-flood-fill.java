class Solution {
    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length]; 
        dfs(image, sr, sc, color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color) {
        if (!isValidIndx(image, sr, sc) || visited[sr][sc]) return;

        visited[sr][sc] = true;

        if (isValidIndx(image, sr + 1, sc) && image[sr][sc] == image[sr + 1][sc])
            dfs(image, sr + 1, sc, color);
        if (isValidIndx(image, sr - 1, sc) && image[sr][sc] == image[sr - 1][sc])
            dfs(image, sr - 1, sc, color);
        if (isValidIndx(image, sr, sc + 1) && image[sr][sc] == image[sr][sc + 1])
            dfs(image, sr, sc + 1, color);
        if (isValidIndx(image, sr, sc - 1) && image[sr][sc] == image[sr][sc - 1])
            dfs(image, sr, sc - 1, color);
        image[sr][sc] = color;
    }

    boolean isValidIndx(int[][] image, int sr, int sc) {
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) return false;
        return true;
    }
}

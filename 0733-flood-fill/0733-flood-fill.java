class Solution {

    int initialColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        initialColor = image[sr][sc];
        dfs(image, sr, sc, color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color) {
        if (!isValidIndex(image, sr, sc) || image[sr][sc] != initialColor || image[sr][sc] == color) return;

        image[sr][sc] = color;
        int[] dx = {0, 1, 0, -1}; 
        int[] dy = {1, 0, -1, 0}; 
        for (int i = 0; i < 4; i++) {
            int x = sr + dx[i];
            int y = sc + dy[i];
            dfs(image, x, y, color);
        }
    }

    boolean isValidIndex(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }
}

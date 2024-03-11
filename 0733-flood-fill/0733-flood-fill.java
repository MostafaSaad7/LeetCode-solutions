class Solution {

    int intialColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        intialColor = image[sr][sc];
        dfs(image, sr, sc, color);
        return image;
    }


    void dfs(int[][] image, int sr, int sc, int color) {
        if (!isValidIndx(image, sr, sc) || image[sr][sc] != intialColor || image[sr][sc] == color) return;


        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color);
        dfs(image, sr - 1, sc, color);
        dfs(image, sr, sc + 1, color);
        dfs(image, sr, sc - 1, color);

    }


    boolean isValidIndx(int[][] image, int sr, int sc) {
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) return false;
        return true;

    }
}
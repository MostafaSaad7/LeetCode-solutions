class Solution {
    char[][] matrixRef;
    int rows, cols;

    public int maximalSquare(char[][] matrix) {
        matrixRef = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        Integer[][] cache = new Integer[rows][cols];

        // considered as topleft corner of the square
        dfs(0, 0, cache);


        int sideLen = 0;
        for (Integer[] row : cache) {
            for (int val : row)
                sideLen = Math.max(sideLen, val);
        }

        return sideLen * sideLen;

    }

    private int dfs(int row, int col, Integer[][] cache) {

        if (row == rows || col == cols)
            return 0;
        if (cache[row][col] != null)
            return cache[row][col];

        int right = dfs(row, col + 1, cache);
        int down = dfs(row + 1, col, cache);
        int diagonal = dfs(row + 1, col + 1, cache);

        int sideLen = matrixRef[row][col] == '1' ? 1 + Math.min(right, Math.min(down, diagonal)) : 0;
        cache[row][col] = sideLen;
        return sideLen;
    }
}